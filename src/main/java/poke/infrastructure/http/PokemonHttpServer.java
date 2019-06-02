package poke.infrastructure.http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("poke")
public class PokemonHttpServer {

  public static void main(String[] args) {
    SpringApplication.run(PokemonHttpServer.class, args);
  }
}
