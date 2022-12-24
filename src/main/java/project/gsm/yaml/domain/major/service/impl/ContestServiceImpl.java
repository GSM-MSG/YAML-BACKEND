package project.gsm.yaml.domain.major.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.major.entity.Major;
import project.gsm.yaml.domain.major.entity.OutsideContest;
import project.gsm.yaml.domain.major.exceptions.ContestNotFoundException;
import project.gsm.yaml.domain.major.presentation.dto.request.ModifyInsideContestRequest;
import project.gsm.yaml.domain.major.presentation.dto.request.ModifyOutsideContestRequest;
import project.gsm.yaml.domain.major.presentation.dto.request.OutsideContestRequest;
import project.gsm.yaml.domain.major.presentation.dto.response.ContestResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.InsideContestResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.SingleOutsideContestResponse;
import project.gsm.yaml.domain.major.repository.OutsideContestRepository;
import project.gsm.yaml.domain.major.service.ContestService;
import project.gsm.yaml.domain.major.utils.MajorCalculateTotalUtil;
import project.gsm.yaml.domain.user.utils.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContestServiceImpl implements ContestService {

    private final UserUtil userUtil;
    private final MajorCalculateTotalUtil majorCalculateTotalUtil;

    private final OutsideContestRepository outsideContestRepository;

    @Override
    public ContestResponse getContest() {
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

    @Override
    public void postContest(OutsideContestRequest outsideContestRequest) {
        OutsideContest outsideContest = OutsideContest.builder()
                .name(outsideContestRequest.getName())
                .fileUrl(outsideContestRequest.getFileURL())
                .build();

        outsideContestRepository.save(outsideContest);
    }

    @Override
    public void patchOutsideContest(Long id, ModifyOutsideContestRequest modifyOutsideContestRequest) {
        OutsideContest outsideContest = outsideContestRepository.findById(id).orElseThrow(() -> new ContestNotFoundException("교육, 대회 참가이력을 찾을 수 없습니다"));
        outsideContest.update(modifyOutsideContestRequest.getName(), modifyOutsideContestRequest.getFileURL());
    }

    @Override
    public void patchInsideContest(ModifyInsideContestRequest modifyInsideContestRequest) {
        Major major = userUtil.currentUser().getMajor();
            major.updateContest(modifyInsideContestRequest.getAttendGsmFestival(), modifyInsideContestRequest.getAttendClubMajorPresentation());
    }
}
