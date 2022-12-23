package project.gsm.yaml.domain.major.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private Integer score;

    private String fileURL;

    @OneToOne
    @JoinColumn(name = "major")
    private Major major;
}
