package project.gsm.yaml.domain.humanities.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "humanities_awards")
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Awards {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String fileURL;

    @ManyToOne
    @JoinColumn(name = "humanities")
    private Humanities humanities;

    public void update(String name, String fileURL) {
        this.name = name;
        this.fileURL = fileURL;
    }
}
