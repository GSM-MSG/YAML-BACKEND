package project.gsm.yaml.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.gsm.yaml.repository.MajorRepository;

@RequiredArgsConstructor
@Service
public class MajorServiceImpl {

    @Autowired
    private final MajorRepository majorRepository;



}
