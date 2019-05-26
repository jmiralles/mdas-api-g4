package poke.domain;

import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonIdList;
import poke.domain.valueobjects.UserId;

public interface FavouritePokemonRepository {
  void addPokemon(UserId userId, PokemonIdList pokemonIds);

  Integer numberOfTimesMarkedAsFavourite(PokemonId pokemonId);
}
