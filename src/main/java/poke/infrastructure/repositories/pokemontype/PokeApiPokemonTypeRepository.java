package poke.infrastructure.repositories.pokemontype;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import poke.domain.PokemonTypeRepository;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonType;
import poke.domain.valueobjects.PokemonTypeList;

import java.util.stream.Collectors;

public class PokeApiPokemonTypeRepository implements PokemonTypeRepository {
  @Override
  public PokemonTypeList find(PokemonId pokemonId) {
    PokeApi pokeApi = new PokeApiClient();
    Pokemon pokemon = pokeApi.getPokemon(pokemonId.getPokemonId());

    return new PokemonTypeList(pokemon.getTypes().stream()
        .map(pokemonType -> new PokemonType(pokemonType.getType().getName()))
        .collect(Collectors.toList()));
  }
}
