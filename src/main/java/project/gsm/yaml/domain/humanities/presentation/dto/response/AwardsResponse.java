package project.gsm.yaml.domain.humanities.presentation.dto.response;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.Awards;

@RequiredArgsConstructor
public class AwardsResponse {
    private final Long id;
    private final String name;
    private final String fileURL;

    public AwardsResponse(Awards awards){
        this.id = awards.getId();
        this.name = awards.getName();
        this.fileURL = awards.getFileUrl();
    }
}
