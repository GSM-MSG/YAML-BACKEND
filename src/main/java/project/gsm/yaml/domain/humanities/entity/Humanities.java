package project.gsm.yaml.domain.humanities.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.gsm.yaml.domain.user.entity.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Humanities {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "humanities")
    private List<Awards> awardsList;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "humanities")
    private List<Book> books;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "humanities")
    private List<Volunteer> volunteers;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "humanities")
    private ChineseCertificate chineseCertificate;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "humanities")
    private HistoryCertificate historyCertificates;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "humanities")
    private Sports sports;

    @Enumerated(EnumType.STRING)
    private InnerSportsLeague sportsLeague;

    @Enumerated(EnumType.STRING)
    private BookMarathon bookMarathon;

    @Enumerated(EnumType.STRING)
    private SchoolSportsCompetition schoolSportsCompetition;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "humanities")
    private User user;

    @PrePersist
    public void prePersist(){
        this.chineseCertificate = this.chineseCertificate == null ? "" : this.chineseCertificate;
        this.historyCertificates = this.historyCertificates == null ? "" : this.historyCertificates;
    }
}
