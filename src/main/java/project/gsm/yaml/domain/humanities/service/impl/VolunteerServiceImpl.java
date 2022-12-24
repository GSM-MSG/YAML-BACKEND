package project.gsm.yaml.domain.humanities.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.humanities.entity.Humanities;
import project.gsm.yaml.domain.humanities.presentation.dto.response.VolunteerResponse;
import project.gsm.yaml.domain.humanities.presentation.dto.response.VolunteersResponse;
import project.gsm.yaml.domain.humanities.repository.VolunteerRepository;
import project.gsm.yaml.domain.humanities.service.VolunteerService;
import project.gsm.yaml.domain.humanities.utils.HumanitiesCaculateTotalUtil;
import project.gsm.yaml.domain.user.utils.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VolunteerServiceImpl implements VolunteerService {

    private final UserUtil userUtil;
    private final HumanitiesCaculateTotalUtil caculateTotalUtil;
    private final VolunteerRepository volunteerRepository;

    @Override
    public VolunteersResponse volunteersExecute() {
        Humanities user = userUtil.currentUser().getHumanities();
        List<VolunteerResponse> volunteerResponseList = user.getVolunteers().stream()
                .map(VolunteerResponse::new)
                .collect(Collectors.toList());
        int hour = user.getVolunteers().stream().map(volunteer -> volunteer.getHour()).reduce(0, (a, b) -> a+b);
        int total = caculateTotalUtil.calculateVounteers(hour);
        return VolunteersResponse.builder()
                .list(volunteerResponseList)
                .total(total)
                .build();
    }
}
