package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.major.entity.OutsideAwards;

@RequiredArgsConstructor
public class SingleOutsideResponse {
    private final Long id;
    private final String name;
    private final String fileURL;

    public SingleOutsideResponse(OutsideAwards outsideAwards) {
        this.id = outsideAwards.getId();
        this.name = outsideAwards.getName();
        this.fileURL = outsideAwards.getFileUrl();
    }
}
