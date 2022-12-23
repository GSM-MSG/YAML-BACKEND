package project.gsm.yaml.domain.humanities.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.humanities.presentation.dto.response.*;
import project.gsm.yaml.domain.humanities.service.PrizeService;
import project.gsm.yaml.domain.humanities.utils.HumanitiesCaculateTotalUtil;
import project.gsm.yaml.domain.user.entity.User;
import project.gsm.yaml.domain.user.utils.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrizeServiceImpl implements PrizeService {
    private final UserUtil userUtil;
    private final HumanitiesCaculateTotalUtil caculateTotalUtil;

    public PrizeResponse prizeExecute() {
        List<AwardsResponse> awardsResponsesList = userUtil.currentUser().getHumanities().getAwardsList().stream()
                .map(AwardsResponse::new)
                .collect(Collectors.toList());
        int total = caculateTotalUtil.calculatePrize(awardsResponsesList.size());
        return PrizeResponse.builder()
                .list(awardsResponsesList)
                .total(total)
                .build();
    }

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
    public VolunteersResponse volunteersExecute() {
        User user = userUtil.currentUser();
        List<VolunteerResponse> volunteerResponseList = user.getHumanities().getVolunteers().stream()
                .map(VolunteerResponse::new)
                .collect(Collectors.toList());
        int hour = user.getHumanities().getVolunteers().stream().map(volunteer -> volunteer.getHour()).reduce(0, (a, b) -> a+b);
        int total = caculateTotalUtil.calculateVounteers(hour);
        return VolunteersResponse.builder()
                .list(volunteerResponseList)
                .total(total)
                .build();
    }
}
