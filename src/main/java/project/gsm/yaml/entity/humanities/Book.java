package project.gsm.yaml.entity.humanities;

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
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String author;
    private String field;
    private String review;
    @ManyToOne
    @JoinColumn(name = "humanities")
    private Humanities humanities;
}
