package poke.domain;

import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonName;

public interface PokemonNameRepository {
  PokemonName get(PokemonId pokemonId);
}
