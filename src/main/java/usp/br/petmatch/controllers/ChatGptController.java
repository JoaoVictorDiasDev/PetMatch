package usp.br.petmatch.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usp.br.petmatch.models.ChatGptModel;
import usp.br.petmatch.repositories.ChatGptRepository;
import usp.br.petmatch.repositories.PetRepository;
import usp.br.petmatch.services.ChatGptService;
import usp.br.petmatch.services.PetService;

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
}
