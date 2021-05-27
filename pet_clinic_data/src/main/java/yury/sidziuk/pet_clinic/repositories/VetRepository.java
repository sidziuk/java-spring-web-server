package yury.sidziuk.pet_clinic.repositories;

import org.springframework.data.repository.CrudRepository;
import yury.sidziuk.pet_clinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
