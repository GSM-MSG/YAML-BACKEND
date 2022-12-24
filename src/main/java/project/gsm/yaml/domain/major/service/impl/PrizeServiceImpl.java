package project.gsm.yaml.domain.major.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.major.entity.Major;
import project.gsm.yaml.domain.major.entity.OutsideAwards;
import project.gsm.yaml.domain.major.exceptions.AwardsNotFoundException;
import project.gsm.yaml.domain.major.presentation.dto.request.ModifyOutsidePrizeRequest;
import project.gsm.yaml.domain.major.presentation.dto.request.OutsidePrizeRequest;
import project.gsm.yaml.domain.major.presentation.dto.response.InsidePrizeResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.PrizeResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.SingleOutsidePrizeResponse;
import project.gsm.yaml.domain.major.repository.OutSideAwardsRepository;
import project.gsm.yaml.domain.major.service.PrizeService;
import project.gsm.yaml.domain.major.utils.MajorCalculateTotalUtil;
import project.gsm.yaml.domain.user.utils.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrizeServiceImpl implements PrizeService {

    private final UserUtil userUtil;
    private final MajorCalculateTotalUtil majorCalculateTotalUtil;

    private final OutSideAwardsRepository outSideAwardsRepository;


    @Override
    public PrizeResponse getPrize() {
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

    @Override
    public void postPrize(OutsidePrizeRequest outsidePrizeRequest) {
        OutsideAwards outsideAwards = OutsideAwards.builder()
                .name(outsidePrizeRequest.getName())
                .fileUrl(outsidePrizeRequest.getFileURL())
                .build();

        outSideAwardsRepository.save(outsideAwards);
    }

    @Override
    public void PatchPrize(Long id, ModifyOutsidePrizeRequest modifyOutsidePrizeRequest) {
        OutsideAwards outsideAwards = outSideAwardsRepository.findById(id).orElseThrow(()-> new AwardsNotFoundException("수상경력을 찾을 수 없습니다"));
        outsideAwards.update(modifyOutsidePrizeRequest.getName(), modifyOutsidePrizeRequest.getFileURL());
    }
}
