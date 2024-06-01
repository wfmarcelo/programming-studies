package com.wollmann;

import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.lang.reflect.RecordComponent;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Base64;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.wollmann.totvs.rmrestdataserver.service.Return;
import com.wollmann.totvs.rmrestdataserver.service.educacional.schema.SAluno;


public class Main {
    public static void main(String[] args) {
        try {
            SAluno aluno = getAsync(SAluno.class);

            var fields = new ArrayList<Field>();
            RecordComponent[] components = SAluno.class.getRecordComponents();
            for (var comp : components) {
                try {
                    Field field = aluno.getClass()
                        .getDeclaredField(comp.getName());
                    field.setAccessible(true);
                    fields.add(field);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            for (var field : fields) {
                System.out.printf("%s: %s%n", field.getName(), field.get(aluno));
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> T getAsync() 
        throws JsonMappingException, JsonProcessingException, InterruptedException, ExecutionException  {
        
        ObjectMapper objectMapper = 
            JsonMapper.builder()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .build();

        String baseUrl = "https://tbc-hlg.uniarp.edu.br:8051/RMSRestDataServer";
        String path = "rest/EduAlunoData/1$_$004169";
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
        System.out.println();

        JavaType type = objectMapper.getTypeFactory()
            .constructParametricType(Return.class, );

        Return<T> result = objectMapper.readValue(content.get(), type);

        return result.data();
        
    }
}