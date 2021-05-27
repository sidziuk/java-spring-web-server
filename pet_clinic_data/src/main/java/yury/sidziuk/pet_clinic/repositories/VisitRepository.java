package yury.sidziuk.pet_clinic.repositories;

import org.springframework.data.repository.CrudRepository;
import yury.sidziuk.pet_clinic.model.Pet;
import yury.sidziuk.pet_clinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
