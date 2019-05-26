package poke.domain;

import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonName;
import poke.domain.valueobjects.PokemonTypeList;

import java.util.Objects;

public class Pokemon {
  private PokemonId id;
  private PokemonName name;
  private PokemonTypeList types;

  public Pokemon(PokemonId id, PokemonName name, PokemonTypeList types) {
    this.id = id;
    this.name = name;
    this.types = types;
  }

  public PokemonId getId() {
    return id;
  }

  public PokemonName getName() {
    return name;
  }

  public PokemonTypeList getTypes() {
    return types;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pokemon pokemon = (Pokemon) o;
    return id.equals(pokemon.id) &&
        name.equals(pokemon.name) &&
        types.equals(pokemon.types);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, types);
  }
}
