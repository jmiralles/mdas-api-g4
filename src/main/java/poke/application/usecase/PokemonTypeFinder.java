package poke.application.usecase;

import poke.domain.PokemonTypeRepository;
import poke.domain.exceptions.PokemonNotFoundException;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonTypeList;

public class PokemonTypeFinder {
  private PokemonTypeRepository pokemonTypeRepository;

  public PokemonTypeFinder(PokemonTypeRepository pokemonTypeRepository) {
    this.pokemonTypeRepository = pokemonTypeRepository;
  }

  public PokemonTypeList invoke(PokemonId pokemonId) throws PokemonNotFoundException {
    return pokemonTypeRepository.find(pokemonId);
  }
}
