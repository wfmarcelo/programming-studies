package com.marcelo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Base64;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class Main {
    public static void main(String[] args) {

        try {
            Aluno aluno = JSONBodyAsMap();

            System.out.println("id: " + aluno.id());
            System.out.println("ra: " + aluno.ra());
            System.out.println("nome: " + aluno.nome());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void get() throws Exception {
        String baseUrl = "https://tbc-hlg.uniarp.edu.br:8051/RMSRestDataServer";
        String path = "rest/EduAlunoData/1$_$015714";
        String username = "mestre";
        String password = "123456";
        String valueToEncode = String.format("%s:%s", username, password);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%s", baseUrl, path)))
                .header("Authorization", "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes()))
                .header("CODCOLIGADA", "1")
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        System.out.println(response.body());
    }

    public static Aluno JSONBodyAsMap() 
        throws JsonMappingException, JsonProcessingException, InterruptedException, ExecutionException  {
        
        ObjectMapper objectMapper = 
            JsonMapper.builder()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .build();

        String baseUrl = "https://tbc-hlg.uniarp.edu.br:8051/RMSRestDataServer";
        String path = "rest/EduAlunoData/1$_$015714";
        String username = "mestre";
        String password = "123456";
        String valueToEncode = String.format("%s:%s", username, password);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/%s", baseUrl, path)))
                .header("Authorization", "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes()))
                .header("CODCOLIGADA", "1")
                .build();

        CompletableFuture<String> content = HttpClient.newHttpClient()
                .sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body);

        SuccessResult<Aluno> result = objectMapper.readValue(content.get(), new TypeReference<SuccessResult<Aluno>>() {});

        return result.data();
        
    }

    

}


