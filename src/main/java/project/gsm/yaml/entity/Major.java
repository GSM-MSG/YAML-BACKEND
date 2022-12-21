package project.gsm.yaml.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

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
    @Column(name = "outside_award")
    private String outsideAward;

    @Column(name = "outside_award_file_url")
    private String outsideAwardFileURL;

    //교내 수상 경력
    @Column(name = "inside_aword")
    private Prize insideAward;

    //교외 대회 및 교육 참가
    @Column(name = "outside_contest")
    private String outsideContest;

    @Column(name = "outside_contest_start_at")
    private String outsideContestStartAt;

    @Column(name = "outside_contest_end_at")
    private String outsideContestEndAt;

    //교내 대회 및 교육 참가
    @Column(name = "inside_contest")
    private String insideContest;

    @Column(name = "inside_contest_start_at")
    private String insideContestStartAt;

    @Column(name = "inside_contest_end_at")
    private String insideContestEndAt;

    //전공동아리
    @Column(name = "mojor_club")
    private String majorClub;

    //전공 / 자격증 항목
    @Column(name = "major_and_certificate")
    private String mojorCertificate;



}
