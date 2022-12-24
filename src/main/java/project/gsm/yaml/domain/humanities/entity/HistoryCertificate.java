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
public class HistoryCertificate {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private HistoryLevel level;
    private String fileURL;

    @OneToOne
    @JoinColumn(name = "humanities")
    private Humanities humanities;

    public void update(HistoryLevel level, String fileURL) {
        this.level = level;
        this.fileURL = fileURL;
    }
}
