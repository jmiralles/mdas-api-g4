package poke.infrastructure.http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PokemonHttpServer {

  public static void main(String[] args) {
    SpringApplication.run(PokemonHttpServer.class, args);
  }
}
