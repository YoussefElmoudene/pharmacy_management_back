package ma.gestion.pharmacie.Repository;

import ma.gestion.pharmacie.entity.Garde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardeRepository extends JpaRepository<Garde, Long> {
}
