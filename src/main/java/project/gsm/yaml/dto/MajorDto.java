package project.gsm.yaml.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import project.gsm.yaml.entity.Major;
import project.gsm.yaml.entity.Prize;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MajorDto {
    private Long id;
    private String outsideAward;
    private String outsideAwardFileURL;
    private Prize insideAward;
    private String outsideContest;
    private String outsideContestStartAt;
    private String outsideContestEndAt;
    private String insideContest;
    private String insideContestStartAt;
    private String insideContestEndAt;
    private String majorClub;
    private String majorCertificate;
    public Major MajorEntity(){
        return Major.builder()
                .id(this.id)
                .outsideAward(this.outsideAward)
                .outsideAwardFileURL(this.outsideAwardFileURL)
                .insideAward(this.insideAward)
                .outsideContest(this.outsideContest)
                .outsideContestStartAt(this.outsideContestStartAt)
                .outsideContestEndAt(this.outsideContestEndAt)
                .insideContest(this.insideContest)
                .insideContestStartAt(this.insideContestStartAt)
                .insideContestEndAt(this.insideContestEndAt)
                .majorClub(this.majorClub)
                .majorCertificate(this.majorCertificate)
                .build();
    }
}
