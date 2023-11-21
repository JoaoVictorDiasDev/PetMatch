package usp.br.petmatch.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import usp.br.petmatch.models.PetModel;
import usp.br.petmatch.repositories.PetRepository;
import usp.br.petmatch.services.PetService;

import java.util.List;

@RestController
public class PetController {
    private final PetRepository petRepository;
    private final PetService petService;

    public PetController(PetRepository petRepository, PetService petService) {
       this.petRepository = petRepository;
       this.petService = petService;
    }

    @GetMapping ("/pets")
    public ResponseEntity<List<PetModel>> getAllPets(){
       return ResponseEntity.status(HttpStatus.OK).body(petRepository.findAll());
    }

    @GetMapping ("/pets/binaryArrays")
    public ResponseEntity<List<int[]>> getAllPetsBinaryArrays(){
        var pets =  petRepository.findAll();
        var binaryArrays = pets.stream().map(PetModel::toBinaryArray).toList();
        return ResponseEntity.status(HttpStatus.OK).body(binaryArrays);
    }

    @CrossOrigin
    @GetMapping ("/findPets")
    public ResponseEntity<List<PetModel>> findPets(){
        var pets = petService.findPets();
        return ResponseEntity.ok(pets);
    }
}
