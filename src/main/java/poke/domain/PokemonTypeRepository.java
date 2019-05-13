package poke.domain;

import poke.domain.exceptions.PokemonNotFoundException;
import poke.domain.valueobjects.PokemonId;

import java.util.List;

public interface PokemonTypeRepository {
  List<String> find(PokemonId pokemonId) throws PokemonNotFoundException;
}
