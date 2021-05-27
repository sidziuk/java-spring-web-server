package yury.sidziuk.pet_clinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import yury.sidziuk.pet_clinic.model.Pet;
import yury.sidziuk.pet_clinic.model.Speciality;
import yury.sidziuk.pet_clinic.model.Vet;
import yury.sidziuk.pet_clinic.services.CrudService;
import yury.sidziuk.pet_clinic.services.PetService;
import yury.sidziuk.pet_clinic.services.SpecialityService;
import yury.sidziuk.pet_clinic.services.VetService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
