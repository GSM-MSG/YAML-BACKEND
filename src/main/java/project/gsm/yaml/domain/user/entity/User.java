package project.gsm.yaml.domain.user.entity;

import lombok.*;
import project.gsm.yaml.domain.user.enums.Gender;
import project.gsm.yaml.domain.user.enums.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class User extends BaseTimeEntity{

    @Id
    private String email;

    @Column
    private String profileUrl;

    @Column
    private Integer grade;

    @Column
    private Integer classNum;

    @Column
    private Integer num;

    @Column
    private Gender gender;

    @Column
    private Role role;
}
