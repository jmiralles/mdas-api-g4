package poke.domain;

import poke.domain.valueobjects.PokemonId;

public interface PokemonDetailsRepository {
  PokemonDetails get(PokemonId pokemonId);
}
