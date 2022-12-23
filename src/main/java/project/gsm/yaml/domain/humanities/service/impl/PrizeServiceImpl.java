package project.gsm.yaml.domain.humanities.service.impl;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.Awards;
import project.gsm.yaml.domain.humanities.presentation.dto.response.AwardsResponse;
import project.gsm.yaml.domain.humanities.presentation.dto.response.PrizeResponse;
import project.gsm.yaml.domain.humanities.service.PrizeService;
import project.gsm.yaml.domain.humanities.utils.CaculateTotalUtil;
import project.gsm.yaml.domain.user.entity.User;
import project.gsm.yaml.domain.user.utils.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PrizeServiceImpl implements PrizeService {
    private final UserUtil userUtil;
    private final CaculateTotalUtil caculateTotalUtil;

    public PrizeResponse prizeExecute(String accessToken) {
        List<AwardsResponse> awardsResponsesList = userUtil.currentUser().getHumanities().getAwardsList().stream()
                .map(AwardsResponse::new)
                .collect(Collectors.toList());
        int total = caculateTotalUtil.calculatePrize(awardsResponsesList.size());
        return PrizeResponse.builder()
                .list(awardsResponsesList)
                .total(total)
                .build();
    }
}
