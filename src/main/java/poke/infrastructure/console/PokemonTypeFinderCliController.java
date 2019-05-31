package poke.infrastructure.console;

import poke.application.PokemonTypeFinder;
import poke.domain.exceptions.PokemonNotFoundException;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonTypeList;
import poke.infrastructure.repositories.pokemontype.PokeApiPokemonTypeRepository;

public class PokemonTypeFinderCliController {
  public static void main(String[] args) {
    try {
      PokeApiPokemonTypeRepository pokeApiPokemonTypeRepository = new PokeApiPokemonTypeRepository();
      PokemonTypeFinder pokemonTypeFinder = new PokemonTypeFinder(pokeApiPokemonTypeRepository);

      PokemonId pokemonId = PokemonId.fromString(args[0]);
      PokemonTypeList typesOfGivenPokemon = pokemonTypeFinder.invoke(pokemonId);

      System.out.println(typesOfGivenPokemon.toString());
    } catch (PokemonNotFoundException e) {
      System.out.println("Unknown Pokemon");

    }
  }
}