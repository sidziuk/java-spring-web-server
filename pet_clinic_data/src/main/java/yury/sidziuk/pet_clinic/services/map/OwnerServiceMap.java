package yury.sidziuk.pet_clinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import yury.sidziuk.pet_clinic.model.Owner;
import yury.sidziuk.pet_clinic.model.Pet;
import yury.sidziuk.pet_clinic.services.OwnerService;
import yury.sidziuk.pet_clinic.services.PetService;
import yury.sidziuk.pet_clinic.services.PetTypeService;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }



    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                       if(pet.getPetType().getId() == null){
                           pet.setPetType(petTypeService.save(pet.getPetType()));
                       }
                    }else{
                        throw new RuntimeException("Pet Type is required");
                    }
                    if(pet.getId() ==null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save( object);
        }else
            return null;

    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String LastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(LastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {

        return null;
    }
}
