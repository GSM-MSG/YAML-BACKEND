package project.gsm.yaml.domain.user.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.gsm.yaml.domain.user.enums.Gender;
import project.gsm.yaml.domain.user.enums.Role;

@Builder
@Getter
@AllArgsConstructor
public class UserResponse {
    private final String email;
    private final String name;
    private final String profileUrl;
    private final Integer grade;
    private final Integer classNum;
    private final Integer number;
    private final Gender gender;
    private final Role role;
}
