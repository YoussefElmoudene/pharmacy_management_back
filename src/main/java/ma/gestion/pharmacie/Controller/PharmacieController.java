package ma.gestion.pharmacie.Controller;


import com.google.gson.Gson;
import ma.gestion.pharmacie.Service.PharmacieService;
import ma.gestion.pharmacie.entity.Pharmacie;
import ma.gestion.pharmacie.vo.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pharmacies")
public class PharmacieController {
    @Autowired
    public PharmacieService pharmacieService;

    @GetMapping("/")
    public List<Pharmacie> findAllPharmacie() {
        return pharmacieService.findAllPharmacie();
    }

    @GetMapping("/id/{id}")
    public Pharmacie findPharmacieById(@PathVariable Long id) throws Exception {
        return pharmacieService.findPharmacieById(id);
    }

    @DeleteMapping("/id/{id}")
    public void deletePharmacie(@PathVariable Long id) {
        pharmacieService.deletePharmacie(id);
    }

    @PostMapping("/")
    public Pharmacie save(@RequestBody Pharmacie pharmacie) {
        return pharmacieService.save(pharmacie);
    }

    @GetMapping("/id/{id}/itineraire")
    public Coordinate get_route_to_pharmacy(@PathVariable Long id, @RequestParam("depart") String coordinate_depart) {
        Coordinate coordinate = new Gson().fromJson(coordinate_depart, Coordinate.class);

        return pharmacieService.get_route_to_pharmacy(id, coordinate);
    }


}
