package ma.gestion.pharmacie.Service;

import ma.gestion.pharmacie.Repository.PharmacieRepository;
import ma.gestion.pharmacie.Repository.ZoneRepository;
import ma.gestion.pharmacie.entity.Pharmacie;
import ma.gestion.pharmacie.entity.Zone;
import ma.gestion.pharmacie.vo.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PharmacieService {

    @Autowired
    private PharmacieRepository pharmacieRepository;
    @Autowired
    private ZoneRepository zoneRepository;

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
        Zone zone = zoneRepository.findById(p.getZone().getId()).get();
        p.setZone(zone);
        return pharmacieRepository.save(p);
    }

    public Coordinate get_route_to_pharmacy(Long id, Coordinate coordinate_depart) {
        try {
            Pharmacie pharmacie = findPharmacieById(id);
            return new Coordinate(pharmacie.getAltitude(), pharmacie.getLongitude());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
