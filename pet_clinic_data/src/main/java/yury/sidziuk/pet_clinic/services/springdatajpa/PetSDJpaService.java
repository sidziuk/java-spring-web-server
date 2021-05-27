package yury.sidziuk.pet_clinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import yury.sidziuk.pet_clinic.model.Pet;
import yury.sidziuk.pet_clinic.repositories.PetRepository;
import yury.sidziuk.pet_clinic.services.PetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {

        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);

        return pets;
    }

    @Override
    public Pet findById(Long id) {
          return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);

    }

}
