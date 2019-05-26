package poke.domain.valueobjects;

import java.util.Objects;

public class PokemonId {
  private Integer pokemonId;

  private PokemonId(Integer pokemonId) {
    this.pokemonId = pokemonId;
  }

  public static PokemonId fromInteger(Integer pokemonId) {
    return new PokemonId(pokemonId);
  }

  public static PokemonId fromString(String pokemonId) {
    return PokemonId.fromInteger(Integer.parseInt(pokemonId));
  }

  public Integer getPokemonId() {
    return pokemonId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PokemonId pokemonId1 = (PokemonId) o;
    return Objects.equals(pokemonId, pokemonId1.pokemonId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pokemonId);
  }
}
