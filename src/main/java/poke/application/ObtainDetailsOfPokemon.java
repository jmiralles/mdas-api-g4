package poke.application;

import poke.domain.PokemonDetails;
import poke.domain.PokemonDetailsRepository;
import poke.domain.valueobjects.PokemonId;

public class ObtainDetailsOfPokemon {
  private PokemonDetailsRepository pokemonDetailsRepository;

  public ObtainDetailsOfPokemon(PokemonDetailsRepository pokemonDetailsRepository) {
    this.pokemonDetailsRepository = pokemonDetailsRepository;
  }

  public PokemonDetails invoke(PokemonId pokemonId) {
    return pokemonDetailsRepository.get(pokemonId);
  }
}
