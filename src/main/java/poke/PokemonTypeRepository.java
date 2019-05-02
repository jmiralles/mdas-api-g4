package poke;

import java.util.List;

public interface PokemonTypeRepository {
  List<String> find(Integer pokemonId);
}
