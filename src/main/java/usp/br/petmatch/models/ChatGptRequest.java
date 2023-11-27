package usp.br.petmatch.models;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1

public class ChatGptRequest {
    public int max_tokens;
    public ArrayList<Message> messages;
    public String model;
    public float temperature;

    public static final String systemInput = """
            A partir de agora você irá se comportar como uma API de um aplicativo para adoção de cachorros.\s     
            Você receberá uma breve descrição do dia-a-dia do usuário e deverá classificar a partir das características primárias e secundárias o cachorro ideal para essa pessoa.           
            As características primárias de classificação e as suas opções são as seguintes: Idade: Bebê, jovem, adulto, idoso; Sexo: macho ou fêmea;Tamanho: pequeno, médio, grande;Pelagem: Crespo, curto, médio, longo e cacheado;Castrado: sim ou não;Treinado: sim ou não;Necessidades especiais: sim ou não;Vacinado: sim ou não;Bom com crianças: sim ou não(o animal precisa gostar de crianças?);Bom com cachorros: sim ou não(o animal precisa gostar de outros cachorros?);Bom com gatos: sim ou não(o animal precisa gostar de gatos?).
            Cada caraterística primária terá duas secundárias. A primeira é a Importância, que é classificada em indiferente, importante, indispensável. A segunda é a justificativa, que explica a escolha da característica primária em até 10 palavras.\s         
            Sua resposta deve conter todas as características e ser  composta exclusivamente pelo objeto JSON, seguindo o seguinte modelo de objeto: { "idade":"Bebê", "importanciaIdade": "Importante", "justificativaIdade": "A pessoa deseja um animal filhote"}.  Todas as características devem estar presentes em um único JSON.            
            Cada chave do JSON não pode conter espaço entre as palavras, a primeira letra deve ser minúscula e não pode conter acentos.\s        
            Você deve necessariamente escolher uma das opções de classificação dentro das especificadas por cada característica, mesmo que não saiba qual classificar.\s          
            """;

    public static String GetChatGptRequestBody(String model, String userInput, int maxTokens, float temperature) {
        ObjectMapper om = new ObjectMapper();
        ChatGptRequest obj = new ChatGptRequest();
        obj.max_tokens = maxTokens;
        obj.model = model;
        obj.temperature = temperature;

        var systemMessage = new Message("system", systemInput);
        var userMessage = new Message("user", userInput);

        obj.messages = new ArrayList<Message>();
        obj.messages.add(systemMessage);
        obj.messages.add(userMessage);

        try {
            return om.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public static class Message {
        public String role;
        public String content;

        public Message(String role, String content) {
           this.role = role;
           this.content = content;
        }
    }
}



