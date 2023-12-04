package usp.br.petmatch.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.br.petmatch.models.ChatGptModel;
import usp.br.petmatch.models.PetModel;
import usp.br.petmatch.repositories.ChatGptRepository;
import usp.br.petmatch.repositories.PetRepository;
import usp.br.petmatch.services.ChatGptService;
import usp.br.petmatch.services.PetService;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatGptController {
    private final ChatGptService chatGptService;

    public ChatGptController(ChatGptService chatGptService) {
        this.chatGptService = chatGptService;
    }


    @PostMapping ("/sendMessage")
    public ResponseEntity<ChatGptModel> saveRequest(@RequestBody String userInput){
        var chatGpt = chatGptService.sendRequest(userInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(chatGpt);
    }

    @CrossOrigin
    @PostMapping ("/findPets")
    public ResponseEntity<List<PetModel>> findPets(@RequestBody String userInput){
        var pets = chatGptService.findPets(userInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(pets);
    }
}
