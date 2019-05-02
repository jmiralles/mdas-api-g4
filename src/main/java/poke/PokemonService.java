package poke;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import poke.exceptions.PokemonNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class PokemonService {
  public List<String> getTypesOfPokemonById(Integer pokemonId) {
    PokeApi pokeApi = new PokeApiClient();
    try {
      Pokemon pokemon = pokeApi.getPokemon(pokemonId);

      return pokemon.getTypes().stream()
          .map(pokemonType -> pokemonType.getType().getName())
          .collect(Collectors.toList());

    } catch (Exception ex) {
      throw new PokemonNotFoundException(ex.getMessage());
    }
  }
}
