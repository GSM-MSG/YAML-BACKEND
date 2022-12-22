package project.gsm.yaml.entity.major;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutsideContest {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String startAt;
    private String endAt;
    @ManyToOne
    @JoinColumn(name = "major")
    private Major major;
}
