package project.gsm.yaml.domain.humanities.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.humanities.entity.Volunteer;
import project.gsm.yaml.domain.humanities.presentation.dto.request.VolunteerRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.response.VolunteerResponse;
import project.gsm.yaml.domain.humanities.presentation.dto.response.VolunteersResponse;
import project.gsm.yaml.domain.humanities.repository.VolunteerRepository;
import project.gsm.yaml.domain.humanities.service.VolunteerService;
import project.gsm.yaml.domain.humanities.utils.HumanitiesCaculateTotalUtil;
import project.gsm.yaml.domain.user.utils.UserUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class VolunteerServiceImpl implements VolunteerService {

    private final UserUtil userUtil;
    private final HumanitiesCaculateTotalUtil caculateTotalUtil;
    private final VolunteerRepository volunteerRepository;

    @Override
    public VolunteersResponse volunteersExecute() {
        Stream<Volunteer> user = userUtil.currentUser().getHumanities().getVolunteers().stream();
        List<VolunteerResponse> volunteerResponseList = user
                .map(VolunteerResponse::new)
                .collect(Collectors.toList());
        int hour = user.map(volunteer -> volunteer.getTime()).reduce(0, (a, b) -> a+b);
        int total = caculateTotalUtil.calculateVounteers(hour);
        return VolunteersResponse.builder()
                .list(volunteerResponseList)
                .total(total)
                .build();
    }

    @Override
    public void postVolunteersExecute(VolunteerRequest volunteerRequest){
        Volunteer volunteer = Volunteer.builder()
                .name(volunteerRequest.getName())
                .time(volunteerRequest.getTime())
                .build();
        volunteerRepository.save(volunteer);
    }
}
