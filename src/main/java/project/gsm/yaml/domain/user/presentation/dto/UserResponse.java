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
    private String email;
    private String name;
    private String profileUrl;
    private Integer grade;
    private Integer classNum;
    private Integer number;
    private Gender gender;
    private Role role;
}
