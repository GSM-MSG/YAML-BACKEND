package project.gsm.yaml.domain.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import project.gsm.yaml.domain.user.presentation.dto.TokenDto;

public interface RedirectService {
    TokenDto execute(String code) throws JsonProcessingException;
}
