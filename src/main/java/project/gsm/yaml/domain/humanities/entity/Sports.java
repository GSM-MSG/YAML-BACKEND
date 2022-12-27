package project.gsm.yaml.domain.humanities.entity;

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
public class Sports {
    @Id
    @GeneratedValue
    private Long id;
    private Marathon marathon;
    private InnerSportsLeague innerLeague;
    private SchoolSportsCompetition schoolCompetition;
    private Integer total;

    @OneToOne
    @JoinColumn(name = "humanities")
    private Humanities humanities;

    public void update(Marathon marathon, InnerSportsLeague innerLeague, SchoolSportsCompetition schoolSportsCompetition, Integer total) {
        this.marathon = marathon;
        this.innerLeague = innerLeague;
        this.schoolCompetition = schoolSportsCompetition;
        this.total = total;
    }
}
