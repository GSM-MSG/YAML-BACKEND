package project.gsm.yaml.domain.humanities.presentation.dto.response;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.Volunteer;

@RequiredArgsConstructor
public class VolunteerResponse {
    private final Long id;
    private final String name;
    private final Integer hour;

    public VolunteerResponse(Volunteer volunteer){
        this.id = volunteer.getId();
        this.name = volunteer.getName();
        this.hour = volunteer.getHour();
    }
}
