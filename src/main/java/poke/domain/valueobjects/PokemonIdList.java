package poke.domain.valueobjects;

import java.util.List;
import java.util.Objects;

public class PokemonIdList {
  private List<PokemonId> pokemonIdList;

  public PokemonIdList(List<PokemonId> pokemonIdList) {
    this.pokemonIdList = pokemonIdList;
  }

  public List<PokemonId> getPokemonIdList() {
    return pokemonIdList;
  }

  public boolean hasPokemonId(PokemonId pokemonId) {
    return pokemonIdList.contains(pokemonId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PokemonIdList that = (PokemonIdList) o;
    return pokemonIdList.equals(that.pokemonIdList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pokemonIdList);
  }
}
