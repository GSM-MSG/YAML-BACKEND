package project.gsm.yaml.domain.major.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.major.entity.Major;
import project.gsm.yaml.domain.major.presentation.dto.request.ModifyMajorClubRequest;
import project.gsm.yaml.domain.major.presentation.dto.response.MajorClubResponse;
import project.gsm.yaml.domain.major.service.MajorClubService;
import project.gsm.yaml.domain.major.utils.MajorCalculateTotalUtil;
import project.gsm.yaml.domain.user.utils.UserUtil;

@Service
@RequiredArgsConstructor
public class MajorClubServiceImpl implements MajorClubService {

    private final UserUtil userUtil;
    private final MajorCalculateTotalUtil majorCalculateTotalUtil;

    @Override
    public MajorClubResponse getMajorClub() {
        String majorClub = userUtil.currentUser().getMajor().getMajorClub();
        int total = majorCalculateTotalUtil.calculateMajorClub(majorClub);
        return MajorClubResponse.builder()
                .name(majorClub)
                .total(total)
                .build();
    }

    @Override
    public void PatchMajorClub(ModifyMajorClubRequest modifyMajorClubRequest) {
        Major major = userUtil.currentUser().getMajor();
            major.updateMajorClub(major.getMajorClub());
    }
}
