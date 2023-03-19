package ma.gestion.pharmacie.Service;

import ma.gestion.pharmacie.Repository.PharmacieRepository;
import ma.gestion.pharmacie.entity.Pharmacie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PharmacieService {

    @Autowired
    private PharmacieRepository pharmacieRepository;

    public List<Pharmacie> findAllPharmacie(){

        return pharmacieRepository.findAll();
    }
    public Optional<Pharmacie> findPharmacieById(Long id){

        return pharmacieRepository.findById(id);
    }

    public void  deletePharmacie(Long id){
        pharmacieRepository.deleteById(id);
    }

    public Pharmacie save(Pharmacie p){
     if(p.getZone().getId()==null){
         return null;
     }else
        return pharmacieRepository.save(p);
    }

    @Query("select p from Pharmacie p where p.zone.ville.id =:id ")
    public List<Pharmacie> findAllPharmacieByVille(int id) {
        return pharmacieRepository.findAllPharmacieByVille(id);
    }

    @Query("select p from Pharmacie p where p.zone.id =:id ")
    public List<Pharmacie> findAllPharmacieByZone(int id) {
        return pharmacieRepository.findAllPharmacieByZone(id);
    }
}
