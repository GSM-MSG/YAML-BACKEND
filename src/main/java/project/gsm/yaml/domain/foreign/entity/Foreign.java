package project.gsm.yaml.domain.foreign.entity;

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
public class Foreign {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Toeic toeic;

    @Enumerated(EnumType.STRING)
    private Toefl toefl;

    @Enumerated(EnumType.STRING)
    private Teps teps;

    @Enumerated(EnumType.STRING)
    private ToeicSpeaking toeicSpeaking;

    @Enumerated(EnumType.STRING)
    private Opic opic;

    @Enumerated(EnumType.STRING)
    private Jpt jpt;

    @Enumerated(EnumType.STRING)
    private Cpt cpt;

    @Enumerated(EnumType.STRING)
    private Hsk hsk;
}
