package poke;

import poke.exceptions.PokemonNotFoundException;

import java.util.List;

public class PokemonTypeFinder {
  private final PokemonTypeRepository pokemonTypeRepository;

  public PokemonTypeFinder(PokemonTypeRepository pokemonTypeRepository) {
    this.pokemonTypeRepository = pokemonTypeRepository;
  }

  public List<String> invoke(Integer pokemonId) throws PokemonNotFoundException {
    try {
      return pokemonTypeRepository.find(pokemonId);
    } catch (Exception ex) {
      throw new PokemonNotFoundException(ex.getMessage());
    }
  }
}
