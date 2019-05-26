package poke.infrastructure.repositories.pokemontype;

import poke.domain.PokemonTypeRepository;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonTypeList;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCachePokemonTypeRepository implements PokemonTypeRepository {
  private final Map<PokemonId, PokemonTypeList> cache = new HashMap<>();
  private final PokemonTypeRepository pokemonTypeRepository;

  public InMemoryCachePokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
    this.pokemonTypeRepository = pokemonTypeRepository;
  }

  @Override
  public PokemonTypeList find(PokemonId pokemonId) {
    if (cache.containsKey(pokemonId)) {
      return cache.get(pokemonId);
    }
    PokemonTypeList pokemonTypes = pokemonTypeRepository.find(pokemonId);
    cache.put(pokemonId, pokemonTypes);
    return pokemonTypes;
  }
}
