package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.major.entity.OutsideAwards;

@RequiredArgsConstructor
public class SingleOutsidePrizeResponse {
    private final Long id;
    private final String name;
    private final String fileURL;

    public SingleOutsidePrizeResponse(OutsideAwards outsideAwards) {
        this.id = outsideAwards.getId();
        this.name = outsideAwards.getName();
        this.fileURL = outsideAwards.getFileUrl();
    }
}
