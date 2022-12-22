package project.gsm.yaml.domain.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.user.entity.RefreshToken;
import project.gsm.yaml.domain.user.exception.exceptioncollection.RefreshTokenNotFoundException;
import project.gsm.yaml.domain.user.presentation.dto.NewTokenResponse;
import project.gsm.yaml.domain.user.repository.RefreshTokenRepository;
import project.gsm.yaml.domain.user.service.RenewTokenService;
import project.gsm.yaml.global.exceptions.exceptioncollection.TokenNotValidException;
import project.gsm.yaml.global.security.jwt.JwtProvider;
import project.gsm.yaml.global.security.jwt.properties.JwtProperties;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class RenewTokenResponseImpl implements RenewTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProvider jwtProvider;
    private final JwtProperties jwtProperties;

    @Override
    public NewTokenResponse execute(String reqToken) {
        String email = jwtProvider.getUserEmail(reqToken, jwtProperties.getRefreshSecret());
        RefreshToken token = refreshTokenRepository.findById(email)
                .orElseThrow(() -> new RefreshTokenNotFoundException("리프레쉬 토큰이 존재하지 없습니다."));
        if(!token.getToken().equals(reqToken)) {
            throw new TokenNotValidException("토큰이 유효하지 않습니다");
        }
        String accessToken = jwtProvider.generateAccessToken(email);
        String refreshToken = jwtProvider.generateRefreshToken(email);
        ZonedDateTime expiredAt = jwtProvider.getExpiredAtToken(accessToken, jwtProperties.getAccessSecret());
        token.exchangeRefreshToken(refreshToken);
        refreshTokenRepository.save(token);
        return NewTokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiredAt(expiredAt)
                .build();
    }
}
