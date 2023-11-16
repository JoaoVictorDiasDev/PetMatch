package usp.br.petmatch.services;

import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import usp.br.petmatch.models.ChatGptModel;
import usp.br.petmatch.repositories.ChatGptRepository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ChatGptService {
    private final ChatGptRepository chatGptRepository;
    Gson gson;

    public ChatGptService(ChatGptRepository chatGptRepository) {
        this.chatGptRepository = chatGptRepository;
        this.gson = new Gson();
    }

    public ChatGptModel sendRequest(String inputUsuario){
        String url = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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";
        String model = "gpt-3.5-turbo-16k";
        String systemInput = "A partir de agora você irá se comportar como uma API de um aplicativo para adoção de cachorros. " +
                "Sua função será receber um input do usuário que é uma breve descrição do seu dia-a-dia e a partir dessa descrição " +
                "você deve dizer quais são as características ideais de um cachorro para essa pessoa. As características e suas " +
                "classificações são as seguintes: Idade: Bebê, jovem, adulto e idoso.  Sexo: macho e fêmea. Tamanho: pequeno, médio" +
                " e grande. Pelagem: Crespo, curto, médio, longo e cacheado. Castrado: sim e não. Treinado: sim e não. Necessidades" +
                " especiais: sim e não. Vacinado: sim e não. Bom com crianças: sim e não. Bom com cachorros: sim e não. Bom com " +
                "gatos: sim e não. Para cada um dos atributos escolhidos você deve atribuir um nível de importância, sendo eles: " +
                "Indiferente, importante, indispensável. Além disso, você deve incluir também uma breve justificativa para sua " +
                "escolha (até 20 palavras).Sua resposta deve ser em formato JSON, seguindo o seguinte objeto: " +
                "{\\\"sexo\\\":\\\"fêmea\\\",\\\"importanciaSexo\\\": \\\"Importante\\\",\\\"justificativaSexo\\\": \\\"Fêmeas são mais amorosas\\\"}. Sua resposta deve ser composta exclusivamente pelo objeto JSON. Cada chave do JSON não " +
                "pode conter espaço entre as palavras, a primeira letra deve ser minúscula e as outras maiúsculas e não pode conter acentos. " +
                "Você tem que necessariamente escolher uma das opções de classificação de característica, preenchendo todos os atributos e não " +
                "deixando nenhum em branco. ";
        try {
            String bodyJson = """
                    {
                       "model": "%s",
                       "messages": [
                            {
                                "role": "system",
                                "content": "%s"
                            },
                            {
                                "role": "user",
                                "content": "%s"
                            }
                        ],
                        "max_tokens": %d
                    }
                    """;
            inputUsuario = new JSONObject(inputUsuario).get("usuarioInput").toString();
            var bodyFormatado = new JSONObject(bodyJson.formatted(model, systemInput, inputUsuario, 10000));

            var request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + apiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(bodyFormatado.toString()))
                    .build();
            var client = HttpClient.newHttpClient();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject resultado = new JSONObject(response.body()).getJSONArray("choices").getJSONObject(0).getJSONObject("message");
            var content = new JSONObject(resultado.get("content").toString());

            var chatGpt = new ChatGptModel();
            chatGpt = gson.fromJson(content.toString(), ChatGptModel.class);
            chatGpt.setInputUsuario(inputUsuario);
            chatGpt.setResposta(response.body());
            return chatGptRepository.save(chatGpt);
        } catch (IOException | JSONException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
