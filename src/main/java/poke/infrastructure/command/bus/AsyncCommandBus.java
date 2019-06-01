package poke.infrastructure.command.bus;

import poke.application.handler.CommandBus;
import poke.application.command.Command;
import poke.infrastructure.command.repository.CommandRepository;
import poke.infrastructure.command.repository.InMemoryCommandRepository;

public class AsyncCommandBus implements CommandBus {
  private final CommandRepository commandRepository = new InMemoryCommandRepository();

  @Override
  public void dispatch(Command command) {
    new Thread(
        () -> commandRepository.getHandlerOfCommand(command).handleCommand(command)
    ).start();
  }
}
