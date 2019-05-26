package poke.domain;

import java.util.Objects;

public class PokemonDetails {
  private Pokemon pokemon;
  private Integer numberOfTimesMarkedAsFavourite;

  public PokemonDetails(Pokemon pokemon, Integer numberOfTimesMarkedAsFavourite) {
    this.pokemon = pokemon;
    this.numberOfTimesMarkedAsFavourite = numberOfTimesMarkedAsFavourite;
  }

  public Pokemon getPokemon() {
    return pokemon;
  }

  public Integer getNumberOfTimesMarkedAsFavourite() {
    return numberOfTimesMarkedAsFavourite;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PokemonDetails that = (PokemonDetails) o;
    return pokemon.equals(that.pokemon) &&
        numberOfTimesMarkedAsFavourite.equals(that.numberOfTimesMarkedAsFavourite);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pokemon, numberOfTimesMarkedAsFavourite);
  }
}
