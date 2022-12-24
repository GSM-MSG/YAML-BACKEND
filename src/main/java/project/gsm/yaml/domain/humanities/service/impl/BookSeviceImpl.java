package project.gsm.yaml.domain.humanities.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.humanities.entity.Book;
import project.gsm.yaml.domain.humanities.entity.Humanities;
import project.gsm.yaml.domain.humanities.exceptions.BooksNotFoundException;
import project.gsm.yaml.domain.humanities.presentation.dto.request.BooksRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.request.ModifyBookMarathonRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.request.ModifyBooksRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.response.BookResponse;
import project.gsm.yaml.domain.humanities.presentation.dto.response.BooksResponse;
import project.gsm.yaml.domain.humanities.repository.BookRepository;
import project.gsm.yaml.domain.humanities.service.BookService;
import project.gsm.yaml.domain.humanities.utils.HumanitiesCaculateTotalUtil;
import project.gsm.yaml.domain.user.entity.User;
import project.gsm.yaml.domain.user.utils.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookSeviceImpl implements BookService {

    private final UserUtil userUtil;
    private final HumanitiesCaculateTotalUtil caculateTotalUtil;

    private final BookRepository bookRepository;

    @Override
    public BooksResponse booksExecute(){
        User user = userUtil.currentUser();
        List<BookResponse> bookResponseList = user.getHumanities().getBooks().stream()
                .map(BookResponse::new)
                .collect(Collectors.toList());
        int marathon = user.getHumanities().getBookMarathon().getScore();
        int total = caculateTotalUtil.calculateBooks(marathon, bookResponseList.size());
        return BooksResponse.builder()
                .list(bookResponseList)
                .bookMarathon(user.getHumanities().getBookMarathon())
                .total(total)
                .build();
    }

    @Override
    public void postBooksExecute(BooksRequest booksRequest){
        Book book = Book.builder()
                .name(booksRequest.getName())
                .author(booksRequest.getAuthor())
                .field(booksRequest.getField())
                .review(booksRequest.getReview())
                .build();

        bookRepository.save(book);
    }

    @Override
    public void patchBooksExecute(Long id, ModifyBooksRequest modifyBooksRequest){
        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new BooksNotFoundException("독서활동 이력을 찾을 수 없습니다."));
        book.update(modifyBooksRequest.getName(), modifyBooksRequest.getAuthor(), modifyBooksRequest.getField(), modifyBooksRequest.getReview());
    }

    @Override
    public void patchBooksMarathonExecute(ModifyBookMarathonRequest modifyBookMarathonRequest){
        Humanities humanities = userUtil.currentUser().getHumanities();
        humanities.updateBooksMarathon(modifyBookMarathonRequest.getBookMarathon());
    }
}
