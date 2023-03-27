package ma.gestion.pharmacie.Service;

import ma.gestion.pharmacie.Repository.GardePharmacieRepository;
import ma.gestion.pharmacie.entity.Gardepharmacie;
import ma.gestion.pharmacie.entity.Pharmacie;
import ma.gestion.pharmacie.entity.PharmacieGardePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GardePharmacieService {
    @Autowired
    public GardePharmacieRepository gradePharmacieRepository;

    public List<Pharmacie> findDisponiblePharmacie(Long zoneId, Date date) {
        return gradePharmacieRepository.findDisponiblePharmacie(zoneId, date);
    }

    public Gardepharmacie save(Gardepharmacie entity) {
        return gradePharmacieRepository.save(entity);
    }

    public Optional<Gardepharmacie> findById(PharmacieGardePK pharmacieGardePK) {
        return gradePharmacieRepository.findById(pharmacieGardePK);
    }

    public boolean existsById(PharmacieGardePK pharmacieGardePK) {
        return gradePharmacieRepository.existsById(pharmacieGardePK);
    }

    public void deleteById(PharmacieGardePK pharmacieGardePK) {
        gradePharmacieRepository.deleteById(pharmacieGardePK);
    }

    public List<Gardepharmacie> findAll() {
        return gradePharmacieRepository.findAll();
    }

    public void delete(Gardepharmacie pg) {
        gradePharmacieRepository.delete(pg);
    }
}
