package ma.gestion.pharmacie.Service;

import ma.gestion.pharmacie.Repository.VilleRepository;
import ma.gestion.pharmacie.entity.Pharmacie;
import ma.gestion.pharmacie.entity.Ville;
import ma.gestion.pharmacie.entity.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VilleService {
    @Autowired
    public VilleRepository villeRepository;
    @Autowired
    private ZoneService zoneService;
    @Autowired
    private GardePharmacieService gardePharmacieService;

    public Ville save(Ville ville) {
        return villeRepository.save(ville);
    }

    public List<Ville> findAll() {
        return villeRepository.findAll();
    }

    public Ville findByNom(String nom) throws Exception {
        Ville v = villeRepository.findByNom(nom);
        if (v == null) {
            throw new Exception("Ville not found.");
        }
        return v;
    }

    public Optional<Ville> findById(Long aLong) {
        return villeRepository.findById(aLong);
    }

    public void delete(Ville ville) {
        villeRepository.delete(ville);
    }

    public List<Pharmacie> findPharmacieByNomVilleAndZone(String nomVille, String nomZone) throws Exception {
        Ville ville = findByNom(nomVille);
        if (ville.getZones().stream().anyMatch(zone -> zone.getNom().equalsIgnoreCase(nomZone))) {
            return ville.getZones().stream().filter(zone -> zone.getNom().equalsIgnoreCase(nomZone)).findAny().get().getPharmacies();
        } else {
            throw new Exception("Pharmacies not found");
        }
    }

    public List<Zone> findZonesByNomVille(String nom) throws Exception {
        Ville ville = findByNom(nom);
        return ville.getZones();
    }

    public List<Pharmacie> findPharmaciesDisponibles(String nomVille, String nomZone, Date dateDonner) throws Exception {
        Ville ville = findByNom(nomVille);
        Zone zone = zoneService.findByNomAndVilleId(nomZone, ville.getId());
        return gardePharmacieService.findDisponiblePharmacie(zone.getId(), dateDonner);
    }

}
