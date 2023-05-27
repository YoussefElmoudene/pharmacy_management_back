package ma.gestion.pharmacie.Controller;

import ma.gestion.pharmacie.Service.GardePharmacieService;
import ma.gestion.pharmacie.entity.Gardepharmacie;
import ma.gestion.pharmacie.entity.Pharmacie;
import ma.gestion.pharmacie.entity.PharmacieGardePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/pharmacieGarde")
public class GardePharmacieController {

    @Autowired
    public GardePharmacieService pharmacieGardeService;

    @GetMapping("/pharmacies/zone/{zoneId}/{date}")
    public List<Pharmacie> findDisponiblePharmacie(@PathVariable Long zoneId, @PathVariable String date) { //'2023-05-27'
        String pattern = "yyyy-MM-dd";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date mydate = null;
        try {
            mydate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return pharmacieGardeService.findDisponiblePharmacie(zoneId, mydate);
    }

    @PostMapping("/")
    public Gardepharmacie save(@RequestBody Gardepharmacie entity) {
        return pharmacieGardeService.save(entity);
    }

    @GetMapping("/")
    public List<Gardepharmacie> findAll() {
        return pharmacieGardeService.findAll();
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestBody PharmacieGardePK pharmacieGardePK) {
        pharmacieGardeService.deleteById(pharmacieGardePK);
    }
}
