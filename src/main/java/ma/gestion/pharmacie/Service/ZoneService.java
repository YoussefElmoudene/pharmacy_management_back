package ma.gestion.pharmacie.Service;

import ma.gestion.pharmacie.Repository.VilleRepository;
import ma.gestion.pharmacie.Repository.ZoneRepository;
import ma.gestion.pharmacie.entity.Ville;
import ma.gestion.pharmacie.entity.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZoneService {

    @Autowired
    public ZoneRepository zoneRepository;
    @Autowired
    public VilleRepository villeRepository;

    public Zone findByNomAndVilleId(String nom, Long id) throws Exception {
        if (zoneRepository.findByNomAndVilleId(nom, id).isPresent()) {
            return zoneRepository.findByNomAndVilleId(nom, id).get();
        } else throw new Exception("Zone not found.");
    }

    public List<Zone> findAllZone() {

        return zoneRepository.findAll();
    }

    public Optional<Zone> findZoneById(Long id) {

        return zoneRepository.findById(id);
    }

    public void deleteZone(Long id) {
        zoneRepository.deleteById(id);
    }

    public Zone save(Zone zone) {
        try {
            Ville ville = villeRepository.findByNom(zone.getVille().getNom());
            zone.setVille(ville);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return zoneRepository.save(zone);
    }

}
