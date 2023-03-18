package ma.gestion.pharmacie.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Pharmacie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String image;
    private double altitude;
    private double longitude;
    @ManyToOne
    private Zone zone;

}
