package project.gsm.yaml.domain.humanities.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Humanities {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "humanities")
    private List<Awards> awardsList;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "humanities")
    private List<Book> books;

    @Enumerated(EnumType.STRING)
    private ChineseCharacter chineseCharacter;

    @Enumerated(EnumType.STRING)
    private KoreanHistoryRating historyRating;

    @Enumerated(EnumType.STRING)
    private InnerSportsLeague sportsLeague;

    @Enumerated(EnumType.STRING)
    private SchoolSportsCompetition schoolSportsCompetition;
}
