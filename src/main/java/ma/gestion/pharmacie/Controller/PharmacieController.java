package ma.gestion.pharmacie.Controller;


import ma.gestion.pharmacie.Service.PharmacieService;
import ma.gestion.pharmacie.entity.Pharmacie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Pharmacie")
public class PharmacieController {
    @Autowired
    public PharmacieService pharmacieService;

   @GetMapping("/")
    public List<Pharmacie> findAllPharmacie() {
        return pharmacieService.findAllPharmacie();
    }
    @GetMapping("/id/{id}")
    public Optional<Pharmacie> findPharmacieById(@PathVariable Long id) {
        return pharmacieService.findPharmacieById(id);
    }
    @DeleteMapping("/id/{id}")
    public void deletePharmacie(@PathVariable Long id) {
        pharmacieService.deletePharmacie(id);
    }
   @PostMapping("/")
    public Pharmacie save(@RequestBody Pharmacie p) {
        return pharmacieService.save(p);
    }
   @GetMapping("/ville/{id}")
    @Query("select p from Pharmacie p where p.zone.ville.id =:id ")
    public List<Pharmacie> findAllPharmacieByVille(int id) {
        return pharmacieService.findAllPharmacieByVille(id);
    }
  @GetMapping("/zone/{id}")
    @Query("select p from Pharmacie p where p.zone.id =:id ")
    public List<Pharmacie> findAllPharmacieByZone(int id) {
        return pharmacieService.findAllPharmacieByZone(id);
    }
}
