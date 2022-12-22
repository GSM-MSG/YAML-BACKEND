package project.gsm.yaml.entity.humanities;

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

    private String fileUrl;

    @ManyToOne
    @JoinColumn(name = "humanities")
    private Humanities humanities;
}
