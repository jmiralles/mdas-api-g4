package poke.application;

import poke.domain.FavouritePokemonRepository;
import poke.domain.valueobjects.PokemonIdList;
import poke.domain.valueobjects.UserId;

public class AddFavouritePokemon {
  private FavouritePokemonRepository favouritePokemonRepository;

  public AddFavouritePokemon(FavouritePokemonRepository favouritePokemonRepository) {
    this.favouritePokemonRepository = favouritePokemonRepository;
  }

  public void invoke(UserId userId, PokemonIdList favouritePokemonIds) {
    favouritePokemonRepository.addPokemon(userId, favouritePokemonIds);
  }
}
