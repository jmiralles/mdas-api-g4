package poke.application.handler;

import poke.application.command.AddFavouritePokemonCommand;
import poke.application.usecase.AddFavouritePokemon;
import poke.domain.valueobjects.PokemonIdList;
import poke.domain.valueobjects.UserId;
import poke.infrastructure.repositories.favouritepokemon.InMemoryFavouritePokemonRepository;

public class AddFavouritePokemonHandler implements CommandHandler<AddFavouritePokemonCommand> {
  private final AddFavouritePokemon addFavouritePokemon = new AddFavouritePokemon(new InMemoryFavouritePokemonRepository());

  @Override
  public void handleCommand(AddFavouritePokemonCommand command) {
    PokemonIdList pokemonIdList = PokemonIdList.fromStringListOfPokemonIds(command.getPokemonIds());
    UserId userIdObject = new UserId(command.getUserId());
    addFavouritePokemon.invoke(userIdObject, pokemonIdList);
  }
}
