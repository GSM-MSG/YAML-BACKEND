package project.gsm.yaml.domain.major.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.gsm.yaml.domain.major.enums.TopcitScore;

import javax.persistence.*;

@Table(name = "major_topcit")
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Topcit {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private TopcitScore score;

    private String fileURL;

    @OneToOne
    @JoinColumn(name = "major")
    private Major major;

    public void update(TopcitScore topcitScore, String fileURL) {
        this.score = topcitScore;
        this.fileURL = fileURL;
    }
}
