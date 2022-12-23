package project.gsm.yaml.domain.humanities.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.logging.Level;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HumanitiesCertificate {
    @Id
    @GeneratedValue
    private Long id;
    private Level level;
    private String fileURL;
    private Integer total;

    @ManyToOne
    @JoinColumn(name = "humanities")
    private Humanities humanities;
}
