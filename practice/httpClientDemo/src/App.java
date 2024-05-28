import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.CompletionException;

public class App {
    public static void main(String[] args) throws Exception {

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
}
