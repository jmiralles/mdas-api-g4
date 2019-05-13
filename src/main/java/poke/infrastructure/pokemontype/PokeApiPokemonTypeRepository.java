package poke.infrastructure.pokemontype;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.springframework.stereotype.Component;
import poke.domain.PokemonTypeRepository;

import java.util.List;
import java.util.stream.Collectors;


@Component("pokeTypeRepository")
public class PokeApiPokemonTypeRepository implements PokemonTypeRepository {
  @Override
  public List<String> find(Integer pokemonId) {
    PokeApi pokeApi = new PokeApiClient();
    Pokemon pokemon = pokeApi.getPokemon(pokemonId);

    return pokemon.getTypes().stream()
        .map(pokemonType -> pokemonType.getType().getName())
        .collect(Collectors.toList());
  }
}
