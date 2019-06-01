package poke.infrastructure.command;

import poke.application.Command;
import poke.application.CommandHandler;

public interface CommandRepository {
  CommandHandler getHandlerOfCommand(Command command);
}
