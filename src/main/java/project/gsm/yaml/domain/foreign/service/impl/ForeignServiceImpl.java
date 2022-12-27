package project.gsm.yaml.domain.foreign.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.foreign.repository.ForeignRepository;
import project.gsm.yaml.domain.foreign.service.ForeignService;

@Service
@RequiredArgsConstructor
public class ForeignServiceImpl implements ForeignService {
    private final ForeignRepository foreignRepository;
}
