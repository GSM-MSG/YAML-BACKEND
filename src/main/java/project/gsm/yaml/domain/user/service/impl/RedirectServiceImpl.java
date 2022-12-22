package project.gsm.yaml.domain.user.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gsm.yaml.domain.user.entity.RefreshToken;
import project.gsm.yaml.domain.user.presentation.dto.GAuthLoginResponse;
import project.gsm.yaml.domain.user.presentation.dto.TokenDto;
import project.gsm.yaml.domain.user.presentation.dto.UserResponse;
import project.gsm.yaml.domain.user.repository.RefreshTokenRepository;
import project.gsm.yaml.domain.user.service.RedirectService;
import project.gsm.yaml.global.security.jwt.JwtProvider;
import project.gsm.yaml.global.security.jwt.properties.JwtProperties;
import project.gsm.yaml.global.security.utils.RedirectUtil;

@Service
@Transactional
@RequiredArgsConstructor
public class RedirectServiceImpl implements RedirectService {

    private final JwtProvider jwtProvider;

    private final JwtProperties jwtProperties;

    private final RedirectUtil redirectUtil;

    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public TokenDto execute(String code) throws JsonProcessingException {

        GAuthLoginResponse getToken = redirectUtil.postCode(code);

        String accessToken = getToken.getAccessToken();

        UserResponse response = redirectUtil.postToSever(accessToken);

        String access = jwtProvider.generateAccessToken(response.getEmail());
        String refresh = jwtProvider.generateRefreshToken(response.getEmail());

        RefreshToken entityToRedis = new RefreshToken(response.getEmail(), refresh, jwtProvider.getREFRESH_TOKEN_EXPIRE_TIME());

        refreshTokenRepository.save(entityToRedis);

        return TokenDto.builder()
                .accessToken(access)
                .refreshToken(refresh)
                .expiredAt(jwtProvider.getExpiredAtToken(access, jwtProperties.getAccessSecret()))
                .build();
    }
}
