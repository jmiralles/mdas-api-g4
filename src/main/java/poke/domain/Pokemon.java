package poke.domain;

import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonName;
import poke.domain.valueobjects.PokemonTypeList;

public class Pokemon {
  private PokemonId id;
  private PokemonName name;
  private PokemonTypeList types;

  public Pokemon(PokemonId id, PokemonName name, PokemonTypeList types) {
    this.id = id;
    this.name = name;
    this.types = types;
  }
}
