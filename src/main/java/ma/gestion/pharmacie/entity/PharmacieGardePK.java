package ma.gestion.pharmacie.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
@NoArgsConstructor
@Getter
@Setter
public class PharmacieGardePK implements Serializable {

    private static final long serialVersionUID = 649786126224382724L;
    private Long pharmacie;
    private Long grade;
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Temporal(TemporalType.DATE)
    private Date datefin;
}
