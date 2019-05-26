package poke.application;

import poke.domain.*;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonName;
import poke.domain.valueobjects.PokemonType;

import java.util.List;

public class GetDetailsOfPokemon {
  private PokemonTypeRepository pokemonTypeRepository;
  private PokemonNameRepository pokemonNameRepository;
  private FavouritePokemonRepository favouritePokemonRepository;

  public GetDetailsOfPokemon(PokemonTypeRepository pokemonTypeRepository,
                             PokemonNameRepository pokemonNameRepository,
                             FavouritePokemonRepository favouritePokemonRepository) {
    this.pokemonTypeRepository = pokemonTypeRepository;
    this.pokemonNameRepository = pokemonNameRepository;
    this.favouritePokemonRepository = favouritePokemonRepository;

  }

  public PokemonDetails invoke(PokemonId pokemonId) {
    List<PokemonType> pokemonTypeList = pokemonTypeRepository.find(pokemonId);
    PokemonName pokemonName = pokemonNameRepository.get(pokemonId);

    Pokemon pokemon = new Pokemon(pokemonId, pokemonName, pokemonTypeList);
    Integer numberOfTimesMarkedAsFavourite = favouritePokemonRepository.numberOfTimesMarkedAsFavourite(pokemonId);

    return new PokemonDetails(pokemon, numberOfTimesMarkedAsFavourite);
  }
}
