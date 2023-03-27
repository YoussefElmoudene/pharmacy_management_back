package ma.gestion.pharmacie.Controller;

import ma.gestion.pharmacie.Service.ZoneService;
import ma.gestion.pharmacie.entity.Zone;
import org.springframework.beans.factory.annotation.Autowired;
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


}
