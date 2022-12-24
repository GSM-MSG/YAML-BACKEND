package project.gsm.yaml.domain.humanities.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.humanities.entity.Awards;
import project.gsm.yaml.domain.major.exceptions.AwardsNotFoundException;
import project.gsm.yaml.domain.humanities.presentation.dto.request.ModifyPrizeRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.request.PrizeRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.response.*;
import project.gsm.yaml.domain.humanities.repository.AwardsRepository;
import project.gsm.yaml.domain.humanities.service.PrizeService;
import project.gsm.yaml.domain.humanities.utils.HumanitiesCaculateTotalUtil;
import project.gsm.yaml.domain.user.utils.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrizeServiceImpl implements PrizeService {
    private final UserUtil userUtil;
    private final HumanitiesCaculateTotalUtil caculateTotalUtil;

    private final AwardsRepository awardsRepository;

    @Override
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

    @Override
    public void postPrizeExecute(PrizeRequest prizeRequest){
        Awards awards = Awards.builder()
                .name(prizeRequest.getName())
                .fileUrl(prizeRequest.getFileURL())
                .build();
        awardsRepository.save(awards);
    }

    @Override
    public void patchPrizeExecute(Long id, ModifyPrizeRequest modifyPrizeRequest){
        Awards awards = awardsRepository.findById(id)
                .orElseThrow(()-> new AwardsNotFoundException("수상경력을 찾을 수 없습니다."));
        awards.update(modifyPrizeRequest.getName(), modifyPrizeRequest.getFileURL());
    }
}
