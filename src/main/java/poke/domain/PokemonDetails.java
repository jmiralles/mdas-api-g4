package poke.domain;

public class PokemonDetails {
  private Pokemon pokemon;
  private Integer numberOfTimesMarkedAsFavourite;

  public PokemonDetails(Pokemon pokemon, Integer numberOfTimesMarkedAsFavourite) {
    this.pokemon = pokemon;
    this.numberOfTimesMarkedAsFavourite = numberOfTimesMarkedAsFavourite;
  }
}
