package project.gsm.yaml.domain.humanities.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.humanities.repository.HumanitiesRepository;

@Service
@RequiredArgsConstructor
public class HumanitiesService {

    private final HumanitiesRepository humanitiesRepository;

}
