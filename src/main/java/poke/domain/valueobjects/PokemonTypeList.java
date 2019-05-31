package poke.domain.valueobjects;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PokemonTypeList {
  private List<PokemonType> pokemonTypeList;

  public PokemonTypeList(List<PokemonType> pokemonTypeList) {
    this.pokemonTypeList = pokemonTypeList;
  }

  public List<PokemonType> getPokemonTypeList() {
    return pokemonTypeList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PokemonTypeList that = (PokemonTypeList) o;
    return pokemonTypeList.equals(that.pokemonTypeList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pokemonTypeList);
  }

  @Override
  public String toString() {
    return pokemonTypeList.stream().map(PokemonType::toString).collect(Collectors.joining(","));
  }

  public List<String> toStringArrayList() {
    return pokemonTypeList.stream().map(PokemonType::getPokemonType).collect(Collectors.toList());
  }
}
