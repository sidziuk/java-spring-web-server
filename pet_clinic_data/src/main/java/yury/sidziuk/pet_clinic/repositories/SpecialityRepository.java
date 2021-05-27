package yury.sidziuk.pet_clinic.repositories;

import org.springframework.data.repository.CrudRepository;
import yury.sidziuk.pet_clinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
