package usp.br.petmatch.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import usp.br.petmatch.models.ChatGptModel;
import usp.br.petmatch.models.ChatGptRequest;
import usp.br.petmatch.repositories.ChatGptRepository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ChatGptService {

    @Value("${chatgpt.api.url}")
    public String CHATGPT_API_URL;
    @Value("${chatgpt.api.key}")
    public String CHATGPT_API_KEY;
    @Value("${chatgpt.api.model}")
    public String CHATGPT_API_MODEL;
    @Value("${chatgpt.api.max.tokens}")
    public String CHATGPT_API_MAX_TOKENS;
    @Value("${chatgpt.api.temperature}")
    public String CHATGPT_API_TEMPERATURE;

    private final ChatGptRepository chatGptRepository;
    ObjectMapper om;

    public ChatGptService(ChatGptRepository chatGptRepository) {
        this.chatGptRepository = chatGptRepository;
        this.om = new ObjectMapper();
    }

    public ChatGptModel sendRequest(String userInput){
        var url = CHATGPT_API_URL;
        var apiKey = CHATGPT_API_KEY;
        var model = CHATGPT_API_MODEL;
        var maxTokens = Integer.parseInt(CHATGPT_API_MAX_TOKENS);
        var temperature = Float.parseFloat(CHATGPT_API_TEMPERATURE);

        var requestBody = ChatGptRequest.GetChatGptRequestBody(model, userInput, maxTokens, temperature);

        try {
            var request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + apiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            var client = HttpClient.newHttpClient();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject resultado = new JSONObject(response.body()).getJSONArray("choices").getJSONObject(0).getJSONObject("message");
            var content = new JSONObject(resultado.get("content").toString());

            var chatGpt = new ChatGptModel();
            chatGpt = om.readValue(content.toString(), ChatGptModel.class);
            chatGpt.setInputUsuario(userInput);
            chatGpt.setResposta(response.body());
            chatGptRepository.save(chatGpt);

            return chatGpt;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
