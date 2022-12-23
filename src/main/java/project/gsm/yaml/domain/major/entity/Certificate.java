package project.gsm.yaml.domain.major.entity;

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
public class Certificate {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String fileURL;
    @ManyToOne
    @JoinColumn(name = "major")
    private Major major;
}
