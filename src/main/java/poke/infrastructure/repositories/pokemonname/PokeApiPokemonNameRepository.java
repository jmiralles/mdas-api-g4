package poke.infrastructure.repositories.pokemonname;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import poke.domain.PokemonNameRepository;
import poke.domain.exceptions.PokemonNotFoundException;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonName;

public class PokeApiPokemonNameRepository implements PokemonNameRepository {
  @Override
  public PokemonName get(PokemonId pokemonId) throws PokemonNotFoundException {
    PokeApi pokeApi = new PokeApiClient();
    try {
      Pokemon apiPokemon = pokeApi.getPokemon(pokemonId.getPokemonId());
      return new PokemonName(apiPokemon.getName());
    } catch (Throwable ex) {
      throw new PokemonNotFoundException();
    }
  }
}
