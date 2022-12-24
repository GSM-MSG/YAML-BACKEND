package project.gsm.yaml.domain.humanities.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ModifyBooksRequest {
    private final String name;
    private final String author;
    private final String field;
    private final String review;
}
