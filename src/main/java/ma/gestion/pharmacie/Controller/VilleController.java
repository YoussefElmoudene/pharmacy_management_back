package ma.gestion.pharmacie.Controller;

import ma.gestion.pharmacie.Service.VilleService;
import ma.gestion.pharmacie.entity.Pharmacie;
import ma.gestion.pharmacie.entity.Ville;
import ma.gestion.pharmacie.entity.Zone;
import ma.gestion.pharmacie.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/villes")
public class VilleController {

    @Autowired
    public VilleService villeService;

    @PostMapping("/")
    public Ville save(@RequestBody Ville ville) {
        return villeService.save(ville);
    }

    @GetMapping("/")
    public List<Ville> findAll() {
        return villeService.findAll();
    }

    @GetMapping("/ville/zones/{nom}")
    public List<Zone> findZonesByNomVille(@PathVariable String nom) throws Exception {
        return villeService.findZonesByNomVille(nom);
    }

    @GetMapping("/ville/{nomVille}/zones/zone/{nomZone}/pharmacies")
    public List<Pharmacie> findPharmacieByNomVilleAndZone(@PathVariable String nomVille, @PathVariable String nomZone) throws Exception {
        return villeService.findPharmacieByNomVilleAndZone(nomVille, nomZone);
    }

    @GetMapping("/ville/{nomVille}/zones/zone/{nomZone}/grade")
    public List<Pharmacie> findPharmaciesDisponibles(@PathVariable String nomVille, @PathVariable String nomZone,
                                                     @RequestParam(value = "periode") String dateDonner) throws Exception {
        return villeService.findPharmaciesDisponibles(nomVille, nomZone, DateUtil.convert_string_to_date(dateDonner));
    }


    @GetMapping("/id/{id}")
    public Optional<Ville> findById(@PathVariable Long id) {
        return villeService.findById(id);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id) {
        villeService.delete(id);
    }
}
