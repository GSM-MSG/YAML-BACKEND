package project.gsm.yaml.domain.major.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "major_outside_awards")
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutsideAwards {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String fileUrl;

    @ManyToOne
    @JoinColumn(name = "major")
    private Major major;

    public void update(String name, String fileUrl) {
        this.name = name;
        this.fileUrl = fileUrl;
    }
}
