package yury.sidziuk.pet_clinic.controllers.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import yury.sidziuk.pet_clinic.model.*;
import yury.sidziuk.pet_clinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }


    private void loadData() {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        System.out.println(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);
        System.out.println(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Tada");
        owner1.setLastName("Jiko");
        owner1.setAddress("100500 Kumba");
        owner1.setCity("Maima");
        owner1.setTelephone("12564568855");



        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Push");

        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Fioa");
        owner2.setLastName("Gonfd");
        owner2.setAddress("1235 Chamba");
        owner2.setCity("Burma");
        owner2.setTelephone("125454545");

        Pet fioaPet = new Pet();
        fioaPet.setPetType(savedCatPetType);
        fioaPet.setOwner(owner2);
        fioaPet.setBirthDate(LocalDate.now());
        fioaPet.setName("Pushok");

        owner2.getPets().add(fioaPet);


        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fioaPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");


        System.out.println("Owners are ready");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Kvax");
        vet1.getSpecialities().add(savedRadiology);


        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Bob");
        vet2.setLastName("Kuk");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Vets are ready");
    }
}