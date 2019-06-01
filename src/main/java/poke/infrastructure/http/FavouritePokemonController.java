package poke.infrastructure.http;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import poke.application.handler.CommandBus;
import poke.application.command.AddFavouritePokemonCommand;
import poke.infrastructure.command.bus.AsyncCommandBus;

import java.util.List;

@RestController
public class FavouritePokemonController {
  private final CommandBus commandBus = new AsyncCommandBus();

  @RequestMapping(method = RequestMethod.POST, path = "/add-favourite-pokemon")
  public void invoke(@RequestParam(value = "userId") String userId, @RequestParam(value = "pokemonIds") List<String> pokemonIds) {
    AddFavouritePokemonCommand addFavouritePokemonCommand = new AddFavouritePokemonCommand(userId, pokemonIds);
    commandBus.dispatch(addFavouritePokemonCommand);
  }
}
