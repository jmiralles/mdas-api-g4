package poke;

import java.util.List;


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