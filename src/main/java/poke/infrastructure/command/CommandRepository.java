package poke.infrastructure.command;

import poke.application.command.Command;
import poke.application.handler.CommandHandler;

public interface CommandRepository {
  CommandHandler getHandlerOfCommand(Command command);
}
