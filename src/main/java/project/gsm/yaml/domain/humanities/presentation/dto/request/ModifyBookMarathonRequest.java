package project.gsm.yaml.domain.humanities.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.BookMarathon;

@Getter
@RequiredArgsConstructor
public class ModifyBookMarathonRequest {
    private final BookMarathon bookMarathon;
}
