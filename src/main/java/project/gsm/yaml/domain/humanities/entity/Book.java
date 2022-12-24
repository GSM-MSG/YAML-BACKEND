package project.gsm.yaml.domain.humanities.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.gsm.yaml.domain.user.entity.User;

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

    public void update(String name, String author, String field, String review){
        this.name = name;
        this.author = author;
        this.field = field;
        this.review = review;
    }

}
