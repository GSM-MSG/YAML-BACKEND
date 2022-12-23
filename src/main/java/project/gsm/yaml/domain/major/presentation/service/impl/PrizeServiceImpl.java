package project.gsm.yaml.domain.major.presentation.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.major.entity.Major;
import project.gsm.yaml.domain.major.presentation.dto.response.InsidePrizeResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.PrizeResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.SingleOutsidePrizeResponse;
import project.gsm.yaml.domain.major.presentation.service.PrizeService;
import project.gsm.yaml.domain.major.utils.MajorCalculateTotalUtil;
import project.gsm.yaml.domain.user.utils.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrizeServiceImpl implements PrizeService {

    private final UserUtil userUtil;
    private final MajorCalculateTotalUtil majorCalculateTotalUtil;


    @Override
    public PrizeResponse execute() {
        Major currentMajor = userUtil.currentUser().getMajor();
        List<SingleOutsidePrizeResponse> outsidePrizeResponseList = currentMajor.getOutsideAwardsList().stream()
                .map(SingleOutsidePrizeResponse::new)
                .collect(Collectors.toList());
        InsidePrizeResponse insidePrizeResponse = new InsidePrizeResponse(currentMajor);
        int total = majorCalculateTotalUtil.calculateMajorPrize(outsidePrizeResponseList.size(), insidePrizeResponse);

        return PrizeResponse.builder()
                .outside(outsidePrizeResponseList)
                .inside(insidePrizeResponse)
                .total(total)
                .build();
    }
}
