package project.gsm.yaml.domain.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import project.gsm.yaml.domain.user.entity.User;

public interface RedirectService {
    void execute(String code) throws JsonProcessingException;
}
