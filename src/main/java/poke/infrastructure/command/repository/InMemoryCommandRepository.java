package poke.infrastructure.command.repository;

import poke.application.Command;
import poke.application.CommandHandler;
import poke.application.handler.AddFavouritePokemonHandler;
import poke.application.command.AddFavouritePokemonCommand;
import poke.infrastructure.command.CommandRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCommandRepository implements CommandRepository {
  private final Map<Class, CommandHandler> commandHandlerMapping = new HashMap<Class, CommandHandler>() {{
    put(AddFavouritePokemonCommand.class, new AddFavouritePokemonHandler());
  }};

  @Override
  public CommandHandler getHandlerOfCommand(Command command) {
    return commandHandlerMapping.get(command.getClass());
  }
}
