package yury.sidziuk.pet_clinic.repositories;

import org.springframework.data.repository.CrudRepository;
import yury.sidziuk.pet_clinic.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);


}
