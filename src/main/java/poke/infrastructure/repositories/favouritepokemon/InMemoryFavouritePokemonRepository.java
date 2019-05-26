package poke.infrastructure.repositories.favouritepokemon;

import poke.domain.FavouritePokemonRepository;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonIdList;
import poke.domain.valueobjects.TimesMarkedAsFavourite;
import poke.domain.valueobjects.UserId;

import java.util.HashMap;
import java.util.Map;

public class InMemoryFavouritePokemonRepository implements FavouritePokemonRepository {
  private final Map<UserId, PokemonIdList> userAndFavouritePokemonDatabase = new HashMap<>();

  @Override
  public void addPokemon(UserId userId, PokemonIdList pokemonIds) {
    userAndFavouritePokemonDatabase.put(userId, pokemonIds);
  }

  @Override
  public TimesMarkedAsFavourite numberOfTimesMarkedAsFavourite(PokemonId pokemonId) {
    return new TimesMarkedAsFavourite(Math.toIntExact(userAndFavouritePokemonDatabase.entrySet().stream()
        .filter((entry) -> entry.getValue().hasPokemonId(pokemonId)).count()));
  }
}
