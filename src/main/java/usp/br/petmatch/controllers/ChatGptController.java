package usp.br.petmatch.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import usp.br.petmatch.models.ChatGptModel;
import usp.br.petmatch.repositories.ChatGptRepository;
import usp.br.petmatch.repositories.PetRepository;
import usp.br.petmatch.services.ChatGptService;
import usp.br.petmatch.services.PetService;

@RestController
public class ChatGptController {
    private final ChatGptRepository chatGptRepository;
    private final ChatGptService chatGptService;

    public ChatGptController(ChatGptRepository chatGptRepository, ChatGptService chatGptService) {
        this.chatGptRepository = chatGptRepository;
        this.chatGptService = chatGptService;
    }

    @PostMapping ("/chatgpt")
    public ResponseEntity<ChatGptModel> saveRequest(@RequestBody String usuarioInput){
        var chatGpt = chatGptService.sendRequest(usuarioInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(chatGpt);
    }
}
