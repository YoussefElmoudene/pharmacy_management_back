package ma.gestion.pharmacie.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Gardepharmacie {

    @EmbeddedId
    private PharmacieGardePK pharmacieGardePK;

    @ManyToOne
    @JoinColumn(name = "grade", insertable = false, nullable = false, updatable = false)
    private Garde grade;

    @ManyToOne
    @JoinColumn(name = "pharmacie", insertable = false, nullable = false, updatable = false)
    private Pharmacie pharmacie;


}
