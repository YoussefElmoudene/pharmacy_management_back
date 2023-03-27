package ma.gestion.pharmacie.Repository;

import ma.gestion.pharmacie.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {
    Optional<Zone> findByNomAndVilleId(String nom, Long id);
}
