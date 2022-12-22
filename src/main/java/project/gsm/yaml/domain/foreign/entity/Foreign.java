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
    private Integer toeic;
    private Integer toefl;
    private Integer teps;
    @Enumerated(EnumType.STRING)
    private ToeicSpeaking toeicSpeaking;
    @Enumerated(EnumType.STRING)
    private Opic opic;
    private Integer jpt;
    private Integer cpt;
    @Enumerated(EnumType.STRING)
    private Hsk hsk;
}
