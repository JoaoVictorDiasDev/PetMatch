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
            From now on you will behave like an API for a dog adoption application.You will receive a brief description of the user's day-to-day life and must classify the ideal dog for that person based on primary and secondary characteristics. The primary classification characteristics and their options are as follows: Age: Baby, young, adult, senior; Sex: male or female; Size: small, medium, large, extra large; Coat: curly, short, medium, long, curly, wire; Neutered: yes or no; House Trained: yes or no; Special needs: yes or no; Vaccinated: yes or no ; Good with children: yes or no (does the animal need to like children?); Good with dogs: yes or no (does the animal need to like other dogs?); Good with cats: yes or no (does the animal need to like cats ?). Your response must contain all the characteristics and be composed exclusively of the JSON object. For the attributes that are binary you can use 1 for "yes" and 0 for "no". For the "sex" atribute you can use "0" for male and "1" for female For example: {"traine": "0"} means the animal don't need to be trained. For the categorical attributes you can use one hot enconding model for representing categorical data, for example: { "age_babe": "0", "age_young": "1", "age_adult": "0", "age_elderly": "0"} means the animal must be young All characteristics must be present in a single JSON. All the attributes must be named in snake case. Each JSON key cannot contain spaces between words, the first letter must be lowercase and cannot contain accents. You must necessarily choose one of the classification options within those specified by each characteristic, even if you don't know which one to classify.
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



