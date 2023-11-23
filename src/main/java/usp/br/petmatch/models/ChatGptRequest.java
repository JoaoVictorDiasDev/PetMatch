package usp.br.petmatch.models;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1

public class ChatGptRequest {
    public int max_tokens;
    public ArrayList<Message> messages;
    public String model;

    public static final String systemInput = """
                A partir de agora você irá se comportar como uma API de um aplicativo para adoção 
                de cachorros. Sua função será receber um input do usuário que é uma breve descrição 
                do seu dia-a-dia e a partir dessa descrição você deve dizer quais são as características ideais 
                de um cachorro para essa pessoa. As características e suas classificações são as seguintes: Idade: 
                Bebê, jovem, adulto e idoso.  Sexo: macho e fêmea. Tamanho: pequeno, médio e grande. Pelagem: Crespo, 
                curto, médio, longo e cacheado. Castrado: sim e não. Treinado: sim e não. Necessidades especiais: sim e não. 
                Vacinado: sim e não. Bom com crianças: sim e não. Bom com cachorros: sim e não. Bom com gatos: sim e não. 
                Para cada um dos atributos escolhidos você deve atribuir um nível de importância, sendo eles: Indiferente, importante, 
                indispensável. Além disso, você deve incluir também uma breve justificativa para sua escolha (até 20 palavras).
                Sua resposta deve ser em formato JSON, seguindo o seguinte objeto: {"sexo":"fêmea","importanciaSexo": "Importante",
                "justificativaSexo": "Fêmeas são mais amorosas"}. Sua resposta deve ser composta exclusivamente pelo objeto JSON. 
                Cada chave do JSON não pode conter espaço entre as palavras, a primeira letra deve ser minúscula e as outras maiúsculas e 
                não pode conter acentos. Você tem que necessariamente escolher uma das opções de classificação de característica, 
                preenchendo todos os atributos e não deixando nenhum em branco.
            """;

    public static String GetChatGptRequestBody(String model, String userInput, int maxTokens) {
        ObjectMapper om = new ObjectMapper();
        ChatGptRequest obj = new ChatGptRequest();
        obj.max_tokens = maxTokens;
        obj.model = model;

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



