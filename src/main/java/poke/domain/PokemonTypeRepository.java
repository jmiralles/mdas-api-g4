package poke.domain;

import poke.domain.exceptions.PokemonNotFoundException;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonType;

import java.util.List;

public interface PokemonTypeRepository {
  List<PokemonType> find(PokemonId pokemonId) throws PokemonNotFoundException;
}
