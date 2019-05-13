package poke.domain;

import poke.domain.valueobjects.UserId;

import java.util.List;

public interface FavouritePokemonRepository {
  void addPokemon(UserId userId, List<String> pokemonIds);
}
