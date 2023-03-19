package ma.gestion.pharmacie.Service;

import ma.gestion.pharmacie.Repository.ZoneRepository;
import ma.gestion.pharmacie.entity.Pharmacie;
import ma.gestion.pharmacie.entity.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZoneService {

    @Autowired
    public ZoneRepository zoneRepository;

    @Query("select z from Zone z where z.ville.id =:id")
    public List<Zone> findAllZoneByVille(int id) {
        return zoneRepository.findAllZoneByVille(id);
    }

    @Query("select z.nom ,(select count(p) from Pharmacie p where p.zone.id=z.id ) from Zone z where z.ville.id=:id group by z.nom")
    public List findNbrPharmacieZone(int id) {
        return zoneRepository.findNbrPharmacieZone(id);
    }

    public List<Zone> findAllZone(){

        return zoneRepository.findAll();
    }
    public Optional<Zone> findZoneById(Long id){

        return zoneRepository.findById(id);
    }

    public void  deleteZone(Long id){
        zoneRepository.deleteById(id);
    }

    public Zone save(Zone zone){
        return zoneRepository.save(zone);
    }

}
