package poke.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import poke.domain.PokemonTypeRepository;
import poke.domain.exceptions.PokemonNotFoundException;

import java.util.List;

@Component("pokeType")
public class PokemonTypeFinder {

  @Autowired
  @Qualifier("pokeTypeRepository")
  private final PokemonTypeRepository pokemonTypeRepository;

  public PokemonTypeFinder(PokemonTypeRepository pokemonTypeRepository) {
    this.pokemonTypeRepository = pokemonTypeRepository;
  }

  public List<String> invoke(Integer pokemonId) throws PokemonNotFoundException {
    return pokemonTypeRepository.find(pokemonId);
  }
}
