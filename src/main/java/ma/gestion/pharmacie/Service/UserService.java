package ma.gestion.pharmacie.Service;

import ma.gestion.pharmacie.Repository.UserRepository;
import ma.gestion.pharmacie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    public UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(User entity) {
        userRepository.delete(entity);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        // TODO Auto-generated method stub

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("user not faound");
        }

        return user;
    }
}
