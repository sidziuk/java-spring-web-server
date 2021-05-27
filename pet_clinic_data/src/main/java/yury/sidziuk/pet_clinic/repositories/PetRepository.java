package yury.sidziuk.pet_clinic.repositories;

import org.springframework.data.repository.CrudRepository;
import yury.sidziuk.pet_clinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
