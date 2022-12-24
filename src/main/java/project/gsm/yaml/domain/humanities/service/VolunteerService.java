package project.gsm.yaml.domain.humanities.service;

import project.gsm.yaml.domain.humanities.presentation.dto.request.VolunteerRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.response.VolunteersResponse;

public interface VolunteerService {
    VolunteersResponse volunteersExecute();

    void postVolunteersExecute(VolunteerRequest volunteerRequest);
}
