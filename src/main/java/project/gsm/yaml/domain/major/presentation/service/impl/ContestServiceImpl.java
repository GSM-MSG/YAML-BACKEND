package project.gsm.yaml.domain.major.presentation.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.major.entity.Major;
import project.gsm.yaml.domain.major.presentation.dto.response.ContestResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.InsideContestResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.SingleOutsideContestResponse;
import project.gsm.yaml.domain.major.presentation.service.ContestService;
import project.gsm.yaml.domain.major.utils.MajorCalculateTotalUtil;
import project.gsm.yaml.domain.user.utils.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContestServiceImpl implements ContestService {

    private final UserUtil userUtil;
    private final MajorCalculateTotalUtil majorCalculateTotalUtil;

    @Override
    public ContestResponse execute() {
        Major currentUserMajor = userUtil.currentUser().getMajor();
        List<SingleOutsideContestResponse> outsideContestResponseList = currentUserMajor.getOutsideContests().stream()
                .map(SingleOutsideContestResponse::new)
                .collect(Collectors.toList());
        InsideContestResponse insideContestResponse = new InsideContestResponse(currentUserMajor);
        int total = majorCalculateTotalUtil.calculateMajorContest(outsideContestResponseList.size(), currentUserMajor.getAfterSchool(), insideContestResponse);
        return ContestResponse.builder()
                .outside(outsideContestResponseList)
                .inside(insideContestResponse)
                .total(total)
                .build();
    }
}
