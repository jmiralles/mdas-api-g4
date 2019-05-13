package poke.infrastructure.repositories.pokemontype;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.springframework.stereotype.Component;
import poke.domain.PokemonTypeRepository;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonType;

import java.util.List;
import java.util.stream.Collectors;


@Component("pokeTypeRepository")
public class PokeApiPokemonTypeRepository implements PokemonTypeRepository {
  @Override
  public List<PokemonType> find(PokemonId pokemonId) {
    PokeApi pokeApi = new PokeApiClient();
    Pokemon pokemon = pokeApi.getPokemon(pokemonId.getPokemonId());

    return pokemon.getTypes().stream()
        .map(pokemonType -> new PokemonType(pokemonType.getType().getName()))
        .collect(Collectors.toList());
  }
}
