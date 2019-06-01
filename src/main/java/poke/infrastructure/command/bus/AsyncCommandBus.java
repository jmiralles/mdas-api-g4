package poke.infrastructure.command.bus;

import poke.application.CommandBus;
import poke.application.Command;
import poke.infrastructure.command.CommandRepository;
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
