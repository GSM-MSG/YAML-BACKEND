package project.gsm.yaml.global.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import project.gsm.yaml.global.exceptions.exceptioncollection.TokenExpirationException;
import project.gsm.yaml.global.exceptions.exceptioncollection.TokenNotValidException;
import project.gsm.yaml.global.security.jwt.auth.AuthDetailsService;
import project.gsm.yaml.global.security.jwt.properties.JwtProperties;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.ZonedDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
@Getter
public class JwtProvider {

    private final AuthDetailsService authDetailsService;

    private final JwtProperties jwtProperties;

    private final long ACCESS_TOKEN_EXPIRE_TIME =60*120*1000;

    private final long REFRESH_TOKEN_EXPIRE_TIME = ACCESS_TOKEN_EXPIRE_TIME*12;

    @AllArgsConstructor
    private enum TokenType {
        ACCESS_TOKEN,
        REFRESH_TOKEN
    }

    private Key getSignInKey(String secretKey) {
        byte[] bytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(bytes);
    }

    private String generateToken(String userEmail, String type, String secret, long expireTime) {
        final Claims claims = Jwts.claims();
        claims.put("type", type);
        claims.put("email", userEmail);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expireTime))
                .signWith(getSignInKey(secret), SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims getTokenBody(String token, String secret) {
        try{
            return Jwts.parserBuilder()
                    .setSigningKey(getSignInKey(secret))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new TokenExpirationException("The token has expired");
        } catch (JwtException e) {
            throw new TokenNotValidException("????????? ???????????? ????????????.");
        }
    }

    public String validateTokenType(String token){
        if(token != null && token.startsWith("Bearer "))
            return token.replace("Bearer ", "");
        return null;
    }

    public ZonedDateTime getExpiredAtToken(String token, String secret) {
        return ZonedDateTime.now().plusSeconds(ACCESS_TOKEN_EXPIRE_TIME);
    }

    public long getExpiredAtTokenToLong() {
        return ACCESS_TOKEN_EXPIRE_TIME/1000L;
    }

    public String generateAccessToken(String email) {
        return generateToken(email, TokenType.ACCESS_TOKEN.name(), jwtProperties.getAccessSecret(), ACCESS_TOKEN_EXPIRE_TIME);
    }

    public String generateRefreshToken(String email) {
        return generateToken(email, TokenType.REFRESH_TOKEN.name(), jwtProperties.getRefreshSecret(), REFRESH_TOKEN_EXPIRE_TIME);
    }
    public UsernamePasswordAuthenticationToken authentication(String token) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(getTokenEmail(token, jwtProperties.getAccessSecret()));
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    public String resolveToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        return validateTokenType(token);
    }

    public String getTokenEmail(String token, String secret) {
        return getTokenBody(token, secret).get("email", String.class);
    }

    public String getUserEmail(String token, String secret) {
        Claims claims = getTokenBody(token, secret);
        return claims.get("email", String.class);
    }
}
