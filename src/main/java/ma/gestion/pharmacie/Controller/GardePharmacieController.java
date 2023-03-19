package ma.gestion.pharmacie.Controller;

import ma.gestion.pharmacie.Service.GardePharmacieService;
import ma.gestion.pharmacie.entity.Gardepharmacie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/pharmaciegarde")
public class GardePharmacieController {

    @Autowired
    public GardePharmacieService pharmacieGardeService;

    public List<Gardepharmacie> findAllPharmacie() {
        return pharmacieGardeService.findAllPharmacie();
    }

//    public Gardepharmacie save(PharmacieGardePK pk) {
//        return pharmacieGardeService.save(pk);
//    }

    public void delete(Gardepharmacie pg) {
        pharmacieGardeService.delete(pg);
    }
}
