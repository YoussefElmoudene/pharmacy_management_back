package ma.gestion.pharmacie.Repository;

import ma.gestion.pharmacie.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Long> {

    @Query("select v.nom ,(select count(p) from Pharmacie p where p.zone.ville.id=v.id and p.etat=1) from Ville v group by v.nom")
    List<Object> findNbrPharmacieVille();

    @Query("select v.nom ,(select count(pg) from Gardepharmacie pg where pg.pharmacie.zone.ville.id=v.id and CURRENT_DATE BETWEEN pg.PharmacieGardePK.dateDebut and pg.PharmacieGardePK.dateFin) from Ville v group by v.nom")
    List<Object> findNbrPharmacieGardeVille();

}
