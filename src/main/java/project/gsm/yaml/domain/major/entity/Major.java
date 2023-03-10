package project.gsm.yaml.domain.major.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.gsm.yaml.domain.user.entity.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Major {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "sequence_id")
    private Long id;

    // 교외 수상 경력
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "major")
    private List<OutsideAwards> outsideAwardsList;

    //교외 대회 및 교육 참가
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "major")
    private List<OutsideContest> outsideContests;

    //교내 대회 및 교육 참가
    private Boolean gsmFestival;

    private Boolean clubMajorPresentation;

    private Boolean attendGsmFestival;

    private Boolean attendClubMajorPresentation;

    private Integer afterSchool;

    private Boolean deepMajorClub;


    //전공동아리
    @Column(name = "major_club")
    private String majorClub;

    //전공 / 자격증 항목
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "major")
    private List<Certificate> certificates;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "major")
    private User user;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "major")
    private Topcit topcit;

    @PrePersist
    public void prePersist(){
        this.majorClub = this.majorClub == null ? "" : this.majorClub;
    }

    public void updatePrize(Boolean gsmFestival, Boolean clubMajorPresentation) {
        this.gsmFestival = gsmFestival;
        this.clubMajorPresentation = clubMajorPresentation;
    }

    public void updateContest(Boolean attendGsmFestival, Boolean attendClubMajorPresentation) {
        this.attendGsmFestival = attendGsmFestival;
        this.attendClubMajorPresentation = attendClubMajorPresentation;
    }

    public void updateMajorClub(String majorClub) {
        this.majorClub = majorClub;
    }
}
