package ma.gestion.pharmacie.Controller;

import ma.gestion.pharmacie.Service.ZoneService;
import ma.gestion.pharmacie.entity.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/zone")
public class ZoneController {
    @Autowired
    public ZoneService zoneService;
    @GetMapping("/")
    public List<Zone> findAllZone() {
        return zoneService.findAllZone();
    }
    @GetMapping("/id/{id}")
    public Optional<Zone> findZoneById(@PathVariable Long id) {
        return zoneService.findZoneById(id);
    }
   @DeleteMapping("/id/{id}")
    public void deleteZone(@PathVariable Long id) {
        zoneService.deleteZone(id);
    }
   @PostMapping("/")
    public Zone save(@RequestBody Zone zone) {
        return zoneService.save(zone);
    }
@GetMapping("/findzone/{id}")
    @Query("select z from Zone z where z.ville.id =:id")
    public List<Zone> findAllZoneByVille(@PathVariable int id) {
        return zoneService.findAllZoneByVille(id);
    }
  @GetMapping("/findpharmacie/{id}")
    @Query("select z.nom ,(select count(p) from Pharmacie p where p.zone.id=z.id ) from Zone z where z.ville.id=:id group by z.nom")
    public List findNbrPharmacieZone(@PathVariable int id) {
        return zoneService.findNbrPharmacieZone(id);
    }
}
