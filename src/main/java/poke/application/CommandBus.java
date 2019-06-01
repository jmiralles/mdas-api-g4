package poke.application;

public interface CommandBus {
  void dispatch(Command command);
}
