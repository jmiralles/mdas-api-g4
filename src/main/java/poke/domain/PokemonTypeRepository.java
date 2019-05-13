package poke.domain;

import poke.domain.exceptions.PokemonNotFoundException;

import java.util.List;

public interface PokemonTypeRepository {
  List<String> find(Integer pokemonId) throws PokemonNotFoundException;
}
