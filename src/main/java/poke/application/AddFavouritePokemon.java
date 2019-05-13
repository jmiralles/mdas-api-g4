package poke.application;

import poke.domain.FavouritePokemonRepository;
import poke.domain.valueobjects.UserId;

import java.util.List;

public class AddFavouritePokemon {
  FavouritePokemonRepository favouritePokemonRepository;

  public AddFavouritePokemon(FavouritePokemonRepository favouritePokemonRepository) {
    this.favouritePokemonRepository = favouritePokemonRepository;
  }

  public void invoke(UserId userId, List<String> favouritePokemonIds) {
    favouritePokemonRepository.addPokemon(userId, favouritePokemonIds);
  }
}
