package poke.infrastructure.repositories.favouritepokemon;

import org.springframework.stereotype.Component;
import poke.domain.FavouritePokemonRepository;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonIdList;
import poke.domain.valueobjects.TimesMarkedAsFavourite;
import poke.domain.valueobjects.UserId;

import java.util.HashMap;
import java.util.Map;

@Component()
public class InMemoryFavouritePokemonRepository implements FavouritePokemonRepository {
  public static HashMap<UserId, PokemonIdList> userAndFavouritePokemonDatabase = new HashMap<UserId,PokemonIdList>();

  @Override
  public void addPokemon(UserId userId, PokemonIdList pokemonIds) {
    this.userAndFavouritePokemonDatabase.put(userId, pokemonIds);
  }

  @Override
  public TimesMarkedAsFavourite numberOfTimesMarkedAsFavourite(PokemonId pokemonId) {
    return new TimesMarkedAsFavourite(Math.toIntExact(this.userAndFavouritePokemonDatabase.entrySet().stream()
        .filter((entry) -> entry.getValue().hasPokemonId(pokemonId)).count()));
  }
}
