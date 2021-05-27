package yury.sidziuk.pet_clinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import yury.sidziuk.pet_clinic.model.Vet;
import yury.sidziuk.pet_clinic.repositories.VetRepository;
import yury.sidziuk.pet_clinic.services.VetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {

        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);

        return vets;
    }

    @Override
    public Vet findById(Long id) {
          return  vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);

    }

}
