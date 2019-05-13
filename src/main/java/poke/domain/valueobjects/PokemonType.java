package poke.domain.valueobjects;

import java.util.Objects;

public class PokemonType {
  private String pokemonType;

  public PokemonType(String pokemonType) {
    this.pokemonType = pokemonType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PokemonType that = (PokemonType) o;
    return Objects.equals(pokemonType, that.pokemonType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pokemonType);
  }

  @Override
  public String toString() {
    return pokemonType;
  }
}
