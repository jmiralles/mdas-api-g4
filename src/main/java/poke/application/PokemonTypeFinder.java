package poke.application;

import poke.domain.PokemonTypeRepository;
import poke.domain.exceptions.PokemonNotFoundException;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonType;

import java.util.List;

public class PokemonTypeFinder {
  private PokemonTypeRepository pokemonTypeRepository;

  public PokemonTypeFinder(PokemonTypeRepository pokemonTypeRepository) {
    this.pokemonTypeRepository = pokemonTypeRepository;
  }

  public List<PokemonType> invoke(PokemonId pokemonId) throws PokemonNotFoundException {
    return pokemonTypeRepository.find(pokemonId);
  }
}
