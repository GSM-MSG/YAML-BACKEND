package project.gsm.yaml.domain.humanities.service.impl;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.BookMarathon;
import project.gsm.yaml.domain.humanities.presentation.dto.response.AwardsResponse;
import project.gsm.yaml.domain.humanities.presentation.dto.response.BookResponse;
import project.gsm.yaml.domain.humanities.presentation.dto.response.BooksResponse;
import project.gsm.yaml.domain.humanities.presentation.dto.response.PrizeResponse;
import project.gsm.yaml.domain.humanities.service.PrizeService;
import project.gsm.yaml.domain.humanities.utils.CaculateTotalUtil;
import project.gsm.yaml.domain.user.entity.User;
import project.gsm.yaml.domain.user.utils.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PrizeServiceImpl implements PrizeService {
    private final UserUtil userUtil;
    private final CaculateTotalUtil caculateTotalUtil;

    public PrizeResponse prizeExecute(String accessToken) {
        List<AwardsResponse> awardsResponsesList = userUtil.currentUser().getHumanities().getAwardsList().stream()
                .map(AwardsResponse::new)
                .collect(Collectors.toList());
        int total = caculateTotalUtil.calculatePrize(awardsResponsesList.size());
        return PrizeResponse.builder()
                .list(awardsResponsesList)
                .total(total)
                .build();
    }

    public BooksResponse booksExecute(String accessToken){
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
}
