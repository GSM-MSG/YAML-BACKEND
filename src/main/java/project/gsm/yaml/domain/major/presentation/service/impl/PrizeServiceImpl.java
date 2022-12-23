package project.gsm.yaml.domain.major.presentation.service.impl;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.major.presentation.dto.response.InsidePrizeResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.PrizeResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.SingleOutsidePrizeResponse;
import project.gsm.yaml.domain.major.presentation.service.PrizeService;
import project.gsm.yaml.domain.user.entity.User;
import project.gsm.yaml.domain.major.utils.CalculateTotalUtil;
import project.gsm.yaml.domain.user.utils.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PrizeServiceImpl implements PrizeService {

    private final UserUtil userUtil;
    private final CalculateTotalUtil calculateTotalUtil;


    @Override
    public PrizeResponse execute() {
        User currentUser = userUtil.currentUser();
        List<SingleOutsidePrizeResponse> outsidePrizeResponseList = currentUser.getMajor().getOutsideAwardsList().stream()
                .map(SingleOutsidePrizeResponse::new)
                .collect(Collectors.toList());
        InsidePrizeResponse insidePrizeResponse = new InsidePrizeResponse(currentUser.getMajor().getGsmFestival(), currentUser.getMajor().getClubMajorPresentation());
        int total = calculateTotalUtil.calculatePrize(outsidePrizeResponseList.size(), insidePrizeResponse.getGsmFestival(), insidePrizeResponse.getMajorClubPresentation());
        return PrizeResponse.builder()
                .outside(outsidePrizeResponseList)
                .inside(insidePrizeResponse)
                .total(total)
                .build();
    }
}
