package usp.br.petmatch.services;
import org.springframework.stereotype.Service;
import usp.br.petmatch.models.PetModel;
import usp.br.petmatch.repositories.PetRepository;

import java.util.Comparator;
import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<PetModel> findPets(PetModel referencePet){
        var allPets = getAllPets();
        var referencePetBinaryArray = referencePet.toBinaryArray();
        calculateAllJaccardDistances(referencePetBinaryArray, allPets);
        allPets.sort(Comparator.comparing(PetModel::getDistanceToCurrentReference));
        return allPets.subList(0, 10);
    }

    public void calculateAllJaccardDistances(int[] referencePetBinaryArray, List<PetModel> pets){
        for (var currentPet : pets){
            var currentPetBinaryArray = currentPet.toBinaryArray();
            var distance = calculateJaccardDistance(referencePetBinaryArray, currentPetBinaryArray);
            currentPet.setDistanceToCurrentReference(distance);
        }
    }

    public Double calculateJaccardDistance(int[] a, int [] b){
        var intersection = 0;
        var union = 0;

        for (int i = 0; i < a.length; i++) {
            intersection += a[i] & b[i]; // Bitwise AND to calculate the intersection
            union += a[i] | b[i]; // Bitwise OR to calculate the union
        }

        if (union == 0) {
            return 0.0;
        } else {
            return 1.0 - (double) intersection / union;
        }
    }

    public List<PetModel> getAllPets(){
        return petRepository.findAll();
    }
}
