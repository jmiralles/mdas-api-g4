package poke.infrastructure.console;

import poke.domain.exceptions.PokemonNotFoundException;
import poke.domain.valueobjects.PokemonId;
import poke.infrastructure.repositories.pokemontype.PokeApiPokemonTypeRepository;
import poke.application.PokemonTypeFinder;

import java.util.List;

public class PokemonTypeFinderCliController {
  public static void main(String[] args) {
    try {
      PokeApiPokemonTypeRepository pokeApiPokemonTypeRepository = new PokeApiPokemonTypeRepository();
      PokemonTypeFinder pokemonTypeFinder = new PokemonTypeFinder(pokeApiPokemonTypeRepository);

      PokemonId pokemonId = new PokemonId(Integer.parseInt(args[0]));
      List<String> typesOfGivenPokemon = pokemonTypeFinder.invoke(pokemonId);

      typesOfGivenPokemon.forEach(System.out::println);
    } catch (PokemonNotFoundException e) {
      System.out.println("Exception in POKEMON API:- " + e);
    }
  }
}