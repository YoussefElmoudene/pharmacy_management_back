package ma.gestion.pharmacie.Service;

import ma.gestion.pharmacie.Repository.GardeRepository;
import ma.gestion.pharmacie.entity.Garde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GardeService {
    @Autowired
    public GardeRepository gardeRepository;

    public  Garde save(Garde garde) {
        return gardeRepository.save(garde);
    }

    public void delete(Garde entity) {
        gardeRepository.delete(entity);
    }

    public Optional<Garde> findByid(long id){
        return gardeRepository.findById(id);
    }
     public List<Garde> findAll(){
        return gardeRepository.findAll();
     }
}
