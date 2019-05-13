package poke.domain;

import poke.infrastructure.exceptions.PokemonNotFoundException;

import java.util.List;

public interface PokemonTypeRepository {
  List<String> find(Integer pokemonId) throws PokemonNotFoundException;
}
