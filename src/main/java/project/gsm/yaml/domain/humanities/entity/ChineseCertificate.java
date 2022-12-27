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
public class ChineseCertificate {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private ChineseLevel level;
    private String fileURL;

    @OneToOne
    @JoinColumn(name = "humanities")
    private Humanities humanities;

    @PrePersist
    public void prePersist(){
        this.fileURL = this.fileURL == null ? "" : this.fileURL;
    }

    public void update(ChineseLevel level, String fileURL) {
        this.level = level;
        this.fileURL = fileURL;
    }
}
