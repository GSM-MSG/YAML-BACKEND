package project.gsm.yaml.domain.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.user.entity.BlackList;
import project.gsm.yaml.domain.user.entity.RefreshToken;
import project.gsm.yaml.domain.user.entity.User;
import project.gsm.yaml.domain.user.exception.exceptioncollection.BlackListAlreadyExistException;
import project.gsm.yaml.domain.user.exception.exceptioncollection.RefreshTokenNotFoundException;
import project.gsm.yaml.domain.user.repository.BlackListRepository;
import project.gsm.yaml.domain.user.repository.RefreshTokenRepository;
import project.gsm.yaml.domain.user.service.LogoutService;
import project.gsm.yaml.global.security.jwt.JwtProvider;
import project.gsm.yaml.global.security.utils.UserUtil;

@Service
@RequiredArgsConstructor
public class LogoutServiceImpl implements LogoutService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final BlackListRepository blackListRepository;
    private final RedisTemplate redisTemplate;
    private final UserUtil userUtil;
    private final JwtProvider jwtProvider;

    @Override
    public void execute(String accessToken) {
        User user = userUtil.currentUser();
        RefreshToken refreshToken = refreshTokenRepository.findRefreshTokenByEmail(user.getEmail()).orElseThrow(()-> new RefreshTokenNotFoundException("리프레시 토큰을 찾을 수 없습니다"));
        refreshTokenRepository.delete(refreshToken);
        saveBlackList(user.getEmail(), accessToken);
    }

    private void saveBlackList(String email, String accessToken) {
        if(redisTemplate.opsForValue().get(accessToken)!=null) {
            throw new BlackListAlreadyExistException("블랙리스트에 이미 등록되어있습니다");
        }
        BlackList blackList = BlackList.builder()
                .email(email)
                .accessToken(jwtProvider.validateTokenType(accessToken))
                .timeToLive(jwtProvider.getExpiredAtTokenToLong())
                .build();
        blackListRepository.save(blackList);
    }
}
