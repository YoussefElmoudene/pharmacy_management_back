package ma.gestion.pharmacie.Repository;

import ma.gestion.pharmacie.entity.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie, Long> {

    Optional<Pharmacie> findByNameAndZoneId(String name, Long id);

}
