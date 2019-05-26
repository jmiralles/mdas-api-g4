package poke.domain;

import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonName;
import poke.domain.valueobjects.PokemonType;

import java.util.List;

public class Pokemon {
  private PokemonId id;
  private PokemonName name;
  private List<PokemonType> types;

  public Pokemon(PokemonId id, PokemonName name, List<PokemonType> types) {
    this.id = id;
    this.name = name;
    this.types = types;
  }
}
