package poke.infrastructure.repositories.pokemontype;

import poke.domain.PokemonTypeRepository;
import poke.domain.valueobjects.PokemonId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCachePokemonTypeRepository implements PokemonTypeRepository {
  private final Map<PokemonId, List<String>> cache = new HashMap<>();
  private final PokemonTypeRepository pokemonTypeRepository;

  public InMemoryCachePokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
    this.pokemonTypeRepository = pokemonTypeRepository;
  }

  @Override
  public List<String> find(PokemonId pokemonId) {
    if (cache.containsKey(pokemonId)) {
      return cache.get(pokemonId);
    }
    List<String> pokemonTypes = pokemonTypeRepository.find(pokemonId);
    cache.put(pokemonId, pokemonTypes);
    return pokemonTypes;
  }
}
