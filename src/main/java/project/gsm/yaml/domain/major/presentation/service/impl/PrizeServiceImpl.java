package project.gsm.yaml.domain.major.presentation.service.impl;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.major.presentation.dto.response.PrizeResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.SingleOutsideResponse;
import project.gsm.yaml.domain.major.presentation.service.PrizeService;
import project.gsm.yaml.domain.user.entity.User;
import project.gsm.yaml.domain.user.utils.CalculateTotalUtil;
import project.gsm.yaml.domain.user.utils.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PrizeServiceImpl implements PrizeService {

    private final UserUtil userUtil;
    private final CalculateTotalUtil calculateTotalUtil;


    @Override
    public PrizeResponse execute(String accessToken) {
        User currentUser = userUtil.currentUser();
        List<SingleOutsideResponse> outsidePrizeResponseList = currentUser.getMajor().getOutsideAwardsList().stream()
                .map(SingleOutsideResponse::new)
                .collect(Collectors.toList());
        Boolean gsmFestival = currentUser.getMajor().getGsmFestival();
        Boolean clubMajorPresentation = currentUser.getMajor().getClubMajorPresentation();
        int total = calculateTotalUtil.calculatePrize(outsidePrizeResponseList.size(), gsmFestival, clubMajorPresentation);

        return PrizeResponse.builder()
                .outsideAwardsList(outsidePrizeResponseList)
                .gsmFestival(gsmFestival)
                .majorClubPresentation(clubMajorPresentation)
                .total(total)
                .build();
    }
}
