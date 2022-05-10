package br.com.dio.httpExemplos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class PostRequest {
    public static final String URL_POST = "http://httpbin.org/forms/post";
    public static final String FILE_JSON = "pedido.json";

    public static void main(String[] args) throws IOException, InterruptedException{

        //Solicitação Assincrona

        //Para executar uma solicitação tem que criar o Cliente
        //Criando um novo cliente
        //Cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        //criar a requisição
        HttpRequest request = HttpRequest.newBuilder()
                //.POST(HttpRequest.BodyPublishers.ofFile(Path.of(FILE_JSON)))
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_POST))
                .build();

        //Enviando um solicitação
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

    }
}
