package poke.exceptions;

public class PokemonNotFoundException extends RuntimeException {
  public PokemonNotFoundException(String message) {
    super(message);
  }
}
