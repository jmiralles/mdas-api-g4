package poke.domain;

import poke.domain.valueobjects.PokemonId;

import java.util.Random;

public class PokemonIdMother {
  private static final Random generator = new Random();

  public static PokemonId generateValidPokemonId() {
    return PokemonId.fromInteger(generator.nextInt(100));
  }

  public static PokemonId generateInvalidPokemonId() {
    return PokemonId.fromInteger(-generator.nextInt(100));
  }
}
