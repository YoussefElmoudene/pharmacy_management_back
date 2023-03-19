package ma.gestion.pharmacie.Service;

import ma.gestion.pharmacie.Repository.VilleRepository;
import ma.gestion.pharmacie.entity.Pharmacie;
import ma.gestion.pharmacie.entity.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VilleService {
    @Autowired
    public VilleRepository villeRepository;

    @Query("select v.nom ,(select count(p) from Pharmacie p where p.zone.ville.id=v.id ) from Ville v group by v.nom")
    public List<Object> findNbrPharmacieVille() {
        return villeRepository.findNbrPharmacieVille();
    }

    @Query("select v.nom ,(select count(pg) from Gardepharmacie pg where pg.pharmacie.zone.ville.id=v.id and CURRENT_DATE BETWEEN pg.PharmacieGardePK.dateDebut and pg.PharmacieGardePK.dateFin) from Ville v group by v.nom")
    public List<Object> findNbrPharmacieGardeVille() {
        return villeRepository.findNbrPharmacieGardeVille();
    }

    public Ville save(Ville ville) {
        return villeRepository.save(ville);
    }

    public Optional<Ville> findById(Long aLong) {
        return villeRepository.findById(aLong);
    }

    public void delete(Ville ville) {
        villeRepository.delete(ville);
    }
}
