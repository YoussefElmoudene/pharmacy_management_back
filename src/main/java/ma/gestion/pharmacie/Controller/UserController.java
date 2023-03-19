package ma.gestion.pharmacie.Controller;

import ma.gestion.pharmacie.Service.UserService;
import ma.gestion.pharmacie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    public UserService userService;
  @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }
   @PostMapping("/")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
   @DeleteMapping("/user/user")
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }
   @GetMapping("/id/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return userService.findById(id);
    }
}
