package poke.domain;

import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.UserId;

import java.util.List;

public interface FavouritePokemonRepository {
  void addPokemon(UserId userId, List<PokemonId> pokemonIds);

  Integer numberOfTimesMarkedAsFavourite(PokemonId pokemonId);
}
