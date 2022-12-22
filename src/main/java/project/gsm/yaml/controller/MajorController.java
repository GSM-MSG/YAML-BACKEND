package project.gsm.yaml.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import project.gsm.yaml.service.MajorServiceImpl;

@RequiredArgsConstructor
@RestController
public class MajorController {
    @Autowired
    private final MajorServiceImpl majorService;
}
