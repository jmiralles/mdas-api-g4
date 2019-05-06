package poke;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CachePokemonTypeRepository implements PokemonTypeRepository {
  private final Map<Integer, List<String>> cache = new HashMap<>();
  private final PokemonTypeRepository pokemonTypeRepository;

  public CachePokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
    this.pokemonTypeRepository = pokemonTypeRepository;
  }

  @Override
  public List<String> find(Integer pokemonId) {
    if (cache.containsKey(pokemonId)) {
      return cache.get(pokemonId);
    }
    List<String> pokemonTypes = pokemonTypeRepository.find(pokemonId);
    cache.put(pokemonId, pokemonTypes);
    return pokemonTypes;
  }
}
