package ma.gestion.pharmacie.Service;

import ma.gestion.pharmacie.Repository.PharmacieRepository;
import ma.gestion.pharmacie.entity.Pharmacie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PharmacieService {

    @Autowired
    private PharmacieRepository pharmacieRepository;

    public List<Pharmacie> findAllPharmacie() {

        return pharmacieRepository.findAll();
    }

    public Pharmacie findByNameAndZoneId(String name, Long id) throws Exception {
        Optional<Pharmacie> pharmacie = pharmacieRepository.findByNameAndZoneId(name, id);
        if (pharmacie.isPresent()) return pharmacie.get();
        else throw new Exception("Pharmacie not found.");
    }

    public Pharmacie findPharmacieById(Long id) throws Exception {
        Optional<Pharmacie> pharmacie = pharmacieRepository.findById(id);
        if (pharmacie.isPresent()) return pharmacie.get();
        else throw new Exception("Pharmacie not found.");
    }

    public void deletePharmacie(Long id) {
        pharmacieRepository.deleteById(id);
    }

    public Pharmacie save(Pharmacie p) {
        return pharmacieRepository.save(p);
    }

}
