package yury.sidziuk.pet_clinic.repositories;

import org.springframework.data.repository.CrudRepository;
import yury.sidziuk.pet_clinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
