package poke.infrastructure.repositories.pokemonname;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import poke.domain.PokemonNameRepository;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonName;

public class PokeApiPokemonNameRepository implements PokemonNameRepository {
  @Override
  public PokemonName get(PokemonId pokemonId) {
    PokeApi pokeApi = new PokeApiClient();
    Pokemon apiPokemon = pokeApi.getPokemon(pokemonId.getPokemonId());
    return new PokemonName(apiPokemon.getName());
  }
}
