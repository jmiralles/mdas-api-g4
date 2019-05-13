package poke.domain.valueobjects;

import java.util.Objects;

public class PokemonId {
  Integer pokemonId;

  public PokemonId(Integer pokemonId) {
    this.pokemonId = pokemonId;
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
