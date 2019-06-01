package poke.application.handler;

import poke.application.command.Command;

public interface CommandBus {
  void dispatch(Command command);
}
