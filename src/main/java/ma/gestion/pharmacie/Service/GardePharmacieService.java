package ma.gestion.pharmacie.Service;

import ma.gestion.pharmacie.Repository.GardePharmacieRepository;
import ma.gestion.pharmacie.entity.Gardepharmacie;
import ma.gestion.pharmacie.entity.PharmacieGardePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GardePharmacieService {
    @Autowired
    public GardePharmacieRepository gradePharmacieRepository;

    public List<Gardepharmacie> findAllPharmacie() {
        return gradePharmacieRepository.findAllPharmacie();
    }


//    public Gardepharmacie  save(PharmacieGardePK pk) {
//        return gradePharmacieRepository.save(pk);
//    }

     public Long findById(Long id){
        return gradePharmacieRepository.findById(id);
     }

    public void delete(Gardepharmacie pg) {
        gradePharmacieRepository.delete(pg);
    }
}
