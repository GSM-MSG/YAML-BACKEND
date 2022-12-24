package project.gsm.yaml.domain.major.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.major.entity.Topcit;
import project.gsm.yaml.domain.major.presentation.dto.request.ModifyTopcitRequest;
import project.gsm.yaml.domain.major.presentation.dto.response.TopcitResponse;
import project.gsm.yaml.domain.major.repository.TopcitRepository;
import project.gsm.yaml.domain.major.service.TopcitService;
import project.gsm.yaml.domain.major.utils.MajorCalculateTotalUtil;
import project.gsm.yaml.domain.user.utils.UserUtil;

@Service
@RequiredArgsConstructor
public class TopcitServiceImpl implements TopcitService {

    private final UserUtil userUtil;
    private final MajorCalculateTotalUtil majorCalculateTotalUtil;
    private final TopcitRepository topcitRepository;

    @Override
    public TopcitResponse getTopcit() {
        Topcit topcit = userUtil.currentUser().getMajor().getTopcit();
        int total = majorCalculateTotalUtil.calculateTopcit(topcit.getScore());
        return TopcitResponse.builder()
                .score(topcit.getScore())
                .fileURL(topcit.getFileURL())
                .total(total)
                .build();
    }

    @Override
    public void patchTopcit(ModifyTopcitRequest modifyTopcitRequest) {
        Topcit topcit = userUtil.currentUser().getMajor().getTopcit();
        topcit.update(topcit.getScore(), topcit.getFileURL());
    }

    @Override
    public void deleteTopcit(Long id) {
        topcitRepository.deleteById(id);
    }


}
