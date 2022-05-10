package br.com.dio.httpExemplos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class GetRequest {
    public static final String URL_GET = "https://jsonplaceholder.typicode.com/posts";
    public static void main(String[] args) throws IOException, InterruptedException {

        //Solicitação Sincrona

        //Para executar uma solicitação tem que criar o Cliente
        //Criando um novo cliente
        //Cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        //criar a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_GET))
                .build();

        //Enviando um solicitação
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //Imprimir contéudos que recebemos
        System.out.println(response.statusCode());
        System.out.println(response.body());

    }
}
