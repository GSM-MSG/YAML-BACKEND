package project.gsm.yaml.domain.user.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gsm.yaml.domain.user.entity.User;
import project.gsm.yaml.domain.user.presentation.dto.GAuthLoginResponse;
import project.gsm.yaml.domain.user.presentation.dto.UserResponse;
import project.gsm.yaml.domain.user.service.RedirectService;
import project.gsm.yaml.global.security.utils.ConfigUtils;
import project.gsm.yaml.global.security.utils.RedirectUtil;

@Service
@Transactional
@RequiredArgsConstructor
public class RedirectServiceImpl implements RedirectService {

    private final ConfigUtils configUtils;
    private final RedirectUtil redirectUtil;

    @Override
    public void execute(String code) throws JsonProcessingException {

        GAuthLoginResponse getToken = redirectUtil.postCode(code);

        String accessToken = getToken.getAccessToken();

        UserResponse response = redirectUtil.postToSever(accessToken);

        User user = User.builder()
                    .email(response.getEmail())
                    .name(response.getName())
                    .profileUrl(response.getProfileUrl())
                    .grade(response.getGrade())
                    .classNum(response.getClassNum())
                    .number(response.getNumber())
                    .gender(response.getGender())
                    .role(response.getRole())
                    .build();
    }
}
