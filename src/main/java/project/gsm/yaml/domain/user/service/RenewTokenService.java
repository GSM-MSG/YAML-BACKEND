package project.gsm.yaml.domain.user.service;

import project.gsm.yaml.domain.user.presentation.dto.NewTokenResponse;

public interface RenewTokenService {
    NewTokenResponse execute(String token);
}
