package poke.infrastructure.console;

import poke.application.PokemonTypeFinder;
import poke.domain.exceptions.PokemonNotFoundException;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonType;
import poke.infrastructure.repositories.pokemontype.PokeApiPokemonTypeRepository;

import java.util.List;

public class PokemonTypeFinderCliController {
  public static void main(String[] args) {
    try {
      PokeApiPokemonTypeRepository pokeApiPokemonTypeRepository = new PokeApiPokemonTypeRepository();
      PokemonTypeFinder pokemonTypeFinder = new PokemonTypeFinder(pokeApiPokemonTypeRepository);

      PokemonId pokemonId = new PokemonId(Integer.parseInt(args[0]));
      List<PokemonType> typesOfGivenPokemon = pokemonTypeFinder.invoke(pokemonId);

      typesOfGivenPokemon.forEach(pokemonType -> System.out.println(pokemonType.toString()));
    } catch (PokemonNotFoundException e) {
      System.out.println("Unknown Pokemon");
      System.exit(1);
    }
  }
}