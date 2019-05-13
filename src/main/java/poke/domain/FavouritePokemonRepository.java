package poke.domain;

import java.util.List;

public interface FavouritePokemonRepository {
  void addPokemon(String userId, List<String> pokemonIds);
}
