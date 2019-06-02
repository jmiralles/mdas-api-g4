package poke.domain;

import org.springframework.stereotype.Component;
import poke.domain.exceptions.PokemonNotFoundException;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonTypeList;

public interface PokemonTypeRepository {
  PokemonTypeList find(PokemonId pokemonId) throws PokemonNotFoundException;
}
