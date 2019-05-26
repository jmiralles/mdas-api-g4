package poke.infrastructure.repositories.favouritepokemon;

import poke.domain.FavouritePokemonRepository;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.UserId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryFavouritePokemonRepository implements FavouritePokemonRepository {
  private final Map<UserId, List<PokemonId>> userAndFavouritePokemonDatabase = new HashMap<>();

  @Override
  public void addPokemon(UserId userId, List<PokemonId> pokemonIds) {
    userAndFavouritePokemonDatabase.put(userId, pokemonIds);
  }
}
