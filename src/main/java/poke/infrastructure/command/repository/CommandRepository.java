package poke.infrastructure.command.repository;

import poke.application.command.Command;
import poke.application.handler.CommandHandler;

public interface CommandRepository {
  CommandHandler getHandlerOfCommand(Command command);
}
