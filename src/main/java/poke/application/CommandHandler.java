package poke.application;

public interface CommandHandler<T extends Command> {
  void handleCommand(T command);
}
