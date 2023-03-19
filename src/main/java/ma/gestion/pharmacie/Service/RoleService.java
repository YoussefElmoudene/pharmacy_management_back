package ma.gestion.pharmacie.Service;

import ma.gestion.pharmacie.Repository.RoleRepository;
import ma.gestion.pharmacie.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    public RoleRepository roleRepository;

    public Optional<Role> FindByid(Long id){
        return roleRepository.findById(id);
    }
    public Role save(Role role){
        return roleRepository.save(role);
    }
    public Role findAll(){
        return (Role) roleRepository.findAll();
    }
}
