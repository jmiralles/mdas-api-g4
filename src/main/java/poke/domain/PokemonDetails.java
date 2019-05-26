package poke.domain;

import poke.domain.valueobjects.TimesMarkedAsFavourite;

import java.util.Objects;

public class PokemonDetails {
  private Pokemon pokemon;
  private TimesMarkedAsFavourite numberOfTimesMarkedAsFavourite;

  public PokemonDetails(Pokemon pokemon, TimesMarkedAsFavourite numberOfTimesMarkedAsFavourite) {
    this.pokemon = pokemon;
    this.numberOfTimesMarkedAsFavourite = numberOfTimesMarkedAsFavourite;
  }

  public Pokemon getPokemon() {
    return pokemon;
  }

  public TimesMarkedAsFavourite getNumberOfTimesMarkedAsFavourite() {
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
