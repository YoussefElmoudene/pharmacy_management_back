package ma.gestion.pharmacie.Repository;

import ma.gestion.pharmacie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    User findUserById(Long id );
}
