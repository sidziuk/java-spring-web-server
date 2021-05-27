package yury.sidziuk.pet_clinic.services;

import yury.sidziuk.pet_clinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String LastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
