package poke.domain.valueobjects;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PokemonIdList {
  private List<PokemonId> pokemonIdList;

  private PokemonIdList(List<PokemonId> pokemonIdList) {
    this.pokemonIdList = pokemonIdList;
  }

  public static PokemonIdList fromStringListOfPokemonIds(List<String> pokemonIds) {
    List<PokemonId> pokemonIdList = pokemonIds.stream().map(PokemonId::fromString).collect(Collectors.toList());
    return new PokemonIdList(pokemonIdList);
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
