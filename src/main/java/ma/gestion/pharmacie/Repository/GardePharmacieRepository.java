package ma.gestion.pharmacie.Repository;

import ma.gestion.pharmacie.entity.Gardepharmacie;
import ma.gestion.pharmacie.entity.PharmacieGardePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GardePharmacieRepository extends JpaRepository<Gardepharmacie, PharmacieGardePK> {

    @Query("select pg from Gardepharmacie pg where CURRENT_DATE NOT BETWEEN pg.PharmacieGardePK.dateDebut and pg.PharmacieGardePK.dateFin")
    List<Gardepharmacie> findAllPharmacie();

    Long findById(Long id);
}
