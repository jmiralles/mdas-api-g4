package poke;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class PokeApiApp {
  public static void main(String[] args) {
    try {
      PokemonService pokemonService = new PokemonService();
      Integer pokemonId = Integer.parseInt(args[0]);
      List<String> typesOfGivenPokemon = pokemonService.getTypesOfPokemonById(pokemonId);
      typesOfGivenPokemon.forEach(System.out::println);
    } catch (Exception e) {
      System.out.println("Exception in POKEMON API:- " + e);
    }
  }
}