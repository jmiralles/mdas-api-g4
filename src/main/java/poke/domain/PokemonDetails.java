package poke.domain;

import java.util.List;

public class PokemonDetails {
  private int id;
  private String name;
  private List<String> pokemonTypes;
  private int numberOfTimesMarkedAsFavourite;

  public PokemonDetails(int id, String name, List<String> pokemonTypes, int numberOfTimesMarkedAsFavourite) {
    this.id = id;
    this.name = name;
    this.pokemonTypes = pokemonTypes;
    this.numberOfTimesMarkedAsFavourite = numberOfTimesMarkedAsFavourite;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<String> getPokemonTypes() {
    return pokemonTypes;
  }

  public int getNumberOfTimesMarkedAsFavourite() {
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

    if (id != that.id) {
      return false;
    }
    if (numberOfTimesMarkedAsFavourite != that.numberOfTimesMarkedAsFavourite) {
      return false;
    }
    if (!name.equals(that.name)) {
      return false;
    }
    return pokemonTypes.equals(that.pokemonTypes);

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + name.hashCode();
    result = 31 * result + pokemonTypes.hashCode();
    result = 31 * result + numberOfTimesMarkedAsFavourite;
    return result;
  }
}
