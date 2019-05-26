package poke.domain;

import poke.domain.exceptions.PokemonNotFoundException;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonTypeList;

public interface PokemonTypeRepository {
  PokemonTypeList find(PokemonId pokemonId) throws PokemonNotFoundException;
}
