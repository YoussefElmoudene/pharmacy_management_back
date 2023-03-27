package ma.gestion.pharmacie.Repository;

import ma.gestion.pharmacie.entity.Gardepharmacie;
import ma.gestion.pharmacie.entity.Pharmacie;
import ma.gestion.pharmacie.entity.PharmacieGardePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GardePharmacieRepository extends JpaRepository<Gardepharmacie, PharmacieGardePK> {

    @Query("SELECT g.pharmacie from Gardepharmacie g where g.pharmacie.zone.id =:zoneId  AND g.pharmacieGardePK.datedebut <=  :dateDonner AND  :dateDonner <= g.pharmacieGardePK.datefin")
    List<Pharmacie> findDisponiblePharmacie(@Param("zoneId") Long zoneId, @Param("dateDonner") Date date);

}
