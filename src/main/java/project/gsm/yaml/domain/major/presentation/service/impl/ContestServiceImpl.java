package project.gsm.yaml.domain.major.presentation.service.impl;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.major.entity.Major;
import project.gsm.yaml.domain.major.presentation.dto.response.ContestResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.InsideContestResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.SingleOutsideContestResponse;
import project.gsm.yaml.domain.major.presentation.service.ContestService;
import project.gsm.yaml.domain.major.utils.CalculateTotalUtil;
import project.gsm.yaml.domain.user.entity.User;
import project.gsm.yaml.domain.user.utils.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ContestServiceImpl implements ContestService {

    private final UserUtil userUtil;
    private final CalculateTotalUtil calculateTotalUtil;

    @Override
    public ContestResponse execute() {
        Major currentUserMajor = userUtil.currentUser().getMajor();
        List<SingleOutsideContestResponse> outsideContestResponseList = currentUserMajor.getOutsideContests().stream()
                .map(SingleOutsideContestResponse::new)
                .collect(Collectors.toList());
        InsideContestResponse insideContestResponse = new InsideContestResponse(currentUserMajor.getGsmFestival(), currentUserMajor.getClubMajorPresentation(), currentUserMajor.getAfterSchool(), currentUserMajor.getDeepMajorClub());
        int total = calculateTotalUtil.calculateContest(outsideContestResponseList.size(), currentUserMajor.getAfterSchool(), currentUserMajor.getGsmFestival(), currentUserMajor.getClubMajorPresentation(), currentUserMajor.getDeepMajorClub());
        return ContestResponse.builder()
                .outside(outsideContestResponseList)
                .inside(insideContestResponse)
                .total(total)
                .build();
    }
}
