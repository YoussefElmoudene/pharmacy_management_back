package ma.gestion.pharmacie.Repository;

import ma.gestion.pharmacie.Service.RoleService;
import ma.gestion.pharmacie.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findById(Long id);
    Role findByNom(String nom);

}
