package project.gsm.yaml.domain.humanities.presentation.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.BookMarathon;

import java.util.List;

@Builder
@RequiredArgsConstructor
public class BooksResponse {
    private final List<BookResponse> list;
    private final BookMarathon bookMarathon;
    private final Integer total;
}
