package project.gsm.yaml.domain.user.entity;

import lombok.*;
import project.gsm.yaml.domain.humanities.entity.Book;
import project.gsm.yaml.domain.humanities.entity.Humanities;
import project.gsm.yaml.domain.humanities.entity.Volunteer;
import project.gsm.yaml.domain.major.entity.Major;
import project.gsm.yaml.domain.user.enums.Gender;
import project.gsm.yaml.domain.user.enums.Role;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class User extends BaseTimeEntity{

    @Id
    private String email;

    @Column
    private String name;

    @Column
    private String profileUrl;

    @Column
    private Integer grade;

    @Column
    private Integer classNum;

    @Column
    private Integer number;

    @Column
    private Gender gender;

    @Column
    private Role role;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "user")
    @JoinColumn(name = "major_id")
    private Major major;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "user")
    @JoinColumn(name = "humanities")
    private Humanities humanities;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "user")
    @JoinColumn(name = "book")
    private Book book;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "user")
    @JoinColumn(name = "volunteer")
    private Volunteer volunteer;
}
