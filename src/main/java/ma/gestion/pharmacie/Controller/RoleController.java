package ma.gestion.pharmacie.Controller;

import ma.gestion.pharmacie.Service.RoleService;
import ma.gestion.pharmacie.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/role")
public class RoleController {
    @Autowired
    public RoleService roleService;
    @GetMapping("/id/{id}")
    public Optional<Role> FindByid(@PathVariable Long id) {
        return roleService.FindByid(id);
    }
   @PostMapping("/")
    public Role save(@RequestBody Role role) {
        return roleService.save(role);
    }
   @GetMapping("/")
    public Role findAll() {
        return roleService.findAll();
    }
}
