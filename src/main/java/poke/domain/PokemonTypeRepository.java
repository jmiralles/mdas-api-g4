package poke.domain;

import java.util.List;

public interface PokemonTypeRepository {
  List<String> find(Integer pokemonId);
}
