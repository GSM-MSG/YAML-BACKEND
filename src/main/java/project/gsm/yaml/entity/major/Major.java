package project.gsm.yaml.entity.major;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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

    //교내 수상 경력
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "major")
    private List<InsideAwards> insideAwardsList;

    //교외 대회 및 교육 참가
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "major")
    private List<OutsideContest> outsideContests;

    //교내 대회 및 교육 참가
    private Boolean gsmFestival;

    private Boolean clubMajorPresentation;

    private Integer afterSchool;

    private Boolean deepMajorClub;

    //전공동아리
    @Column(name = "mojor_club")
    private String majorClub;

    //전공 / 자격증 항목
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "major")
    private List<Certificate> certificates;



}
