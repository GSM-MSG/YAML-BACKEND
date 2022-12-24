package project.gsm.yaml.domain.major.service;

import project.gsm.yaml.domain.major.presentation.dto.request.ModifyTopcitRequest;
import project.gsm.yaml.domain.major.presentation.dto.response.TopcitResponse;

public interface TopcitService {
    TopcitResponse getTopcit();

    void patchTopcit(ModifyTopcitRequest modifyTopcitRequest);

    void deleteTopcit(Long id);
}
