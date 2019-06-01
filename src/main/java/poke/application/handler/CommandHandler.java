package poke.application.handler;

import poke.application.command.Command;

public interface CommandHandler<T extends Command> {
  void handleCommand(T command);
}
