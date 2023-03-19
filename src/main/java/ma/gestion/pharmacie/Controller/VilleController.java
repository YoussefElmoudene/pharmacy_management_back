package ma.gestion.pharmacie.Controller;

import ma.gestion.pharmacie.Service.VilleService;
import ma.gestion.pharmacie.entity.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/ville")
public class VilleController {

    @Autowired
    public VilleService villeService;
   @GetMapping("/find/")
    @Query("select v.nom ,(select count(p) from Pharmacie p where p.zone.ville.id=v.id ) from Ville v group by v.nom")
    public List<Object> findNbrPharmacieVille() {
        return villeService.findNbrPharmacieVille();
    }
  @GetMapping("/findgarde/")
    @Query("select v.nom ,(select count(pg) from Gardepharmacie pg where pg.pharmacie.zone.ville.id=v.id and CURRENT_DATE BETWEEN pg.PharmacieGardePK.dateDebut and pg.PharmacieGardePK.dateFin) from Ville v group by v.nom")
    public List<Object> findNbrPharmacieGardeVille() {
        return villeService.findNbrPharmacieGardeVille();
    }
   @PostMapping("/")
    public Ville save(@RequestBody Ville ville) {
        return villeService.save(ville);
    }
  @GetMapping("/id/{id}")
    public Optional<Ville> findById(@PathVariable Long aLong) {
        return villeService.findById(aLong);
    }
   @DeleteMapping("/")
    public void delete(@RequestBody Ville ville) {
        villeService.delete(ville);
    }
}
