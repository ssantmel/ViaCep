import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaCep {




    public Endereco buscaEndereço(String cep){
        URI endereço = URI.create(URI.create("http://viacep.com.br/ws/") + cep + "/json/");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereço)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("não consegui obter endereço a a partir desse cep");
        }
    }

}
