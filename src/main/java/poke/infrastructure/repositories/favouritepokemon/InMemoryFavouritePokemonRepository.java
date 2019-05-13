package poke.infrastructure.repositories.favouritepokemon;

import poke.domain.FavouritePokemonRepository;
import poke.domain.valueobjects.UserId;

import java.util.List;
import java.util.Map;

public class InMemoryFavouritePokemonRepository implements FavouritePokemonRepository {
  Map<UserId, List<String>> userAndFavouritePokemonDatabase;

  @Override
  public void addPokemon(UserId userId, List<String> pokemonIds) {
    userAndFavouritePokemonDatabase.put(userId, pokemonIds);
  }
}
