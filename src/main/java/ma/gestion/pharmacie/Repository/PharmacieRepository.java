package ma.gestion.pharmacie.Repository;

import ma.gestion.pharmacie.entity.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie, Long> {

    @Query("select p from Pharmacie p where p.zone.ville.id =:id ")
    List<Pharmacie> findAllPharmacieByVille(@Param("id") int id);

    @Query("select p from Pharmacie p where p.zone.id =:id ")
    List<Pharmacie> findAllPharmacieByZone(@Param("id") int id);

}
