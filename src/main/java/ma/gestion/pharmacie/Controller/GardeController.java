package ma.gestion.pharmacie.Controller;

import ma.gestion.pharmacie.Service.GardeService;
import ma.gestion.pharmacie.entity.Garde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/garde")
public class GardeController {
    @Autowired
    public GardeService gardeService;

    @PostMapping("/")
    public Garde save(@RequestBody Garde garde) {
        return gardeService.save(garde);
    }


    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        gardeService.deleteById(id);
    }

    @GetMapping("/id/{id}")
    public Optional<Garde> findByid(@PathVariable long id) {
        return gardeService.findByid(id);
    }

    @GetMapping("/")
    public List<Garde> findAll() {
        return gardeService.findAll();
    }
}
