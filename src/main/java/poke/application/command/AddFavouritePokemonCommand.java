package poke.application.command;

import poke.application.Command;

import java.util.List;

public class AddFavouritePokemonCommand implements Command {
  private String userId;
  private List<String> pokemonIds;

  public AddFavouritePokemonCommand(String userId, List<String> pokemonIds) {
    this.userId = userId;
    this.pokemonIds = pokemonIds;
  }

  public String getUserId() {
    return userId;
  }

  public List<String> getPokemonIds() {
    return pokemonIds;
  }
}
