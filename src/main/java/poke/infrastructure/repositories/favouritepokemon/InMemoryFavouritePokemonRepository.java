package poke.infrastructure.repositories.favouritepokemon;

import poke.domain.FavouritePokemonRepository;

import java.util.List;
import java.util.Map;

public class InMemoryFavouritePokemonRepository implements FavouritePokemonRepository {
  Map<String, List<String>> userAndFavouritePokemonDatabase;

  @Override
  public void addPokemon(String userId, List<String> pokemonIds) {
    userAndFavouritePokemonDatabase.put(userId, pokemonIds);
  }
}
