package poke.application.usecase;

import poke.domain.FavouritePokemonRepository;
import poke.domain.Pokemon;
import poke.domain.PokemonDetails;
import poke.domain.PokemonNameRepository;
import poke.domain.PokemonTypeRepository;
import poke.domain.exceptions.PokemonNotFoundException;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonName;
import poke.domain.valueobjects.PokemonTypeList;
import poke.domain.valueobjects.TimesMarkedAsFavourite;

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

  public PokemonDetails invoke(PokemonId pokemonId) throws PokemonNotFoundException {
    PokemonTypeList pokemonTypeList = pokemonTypeRepository.find(pokemonId);
    PokemonName pokemonName = pokemonNameRepository.get(pokemonId);

    Pokemon pokemon = new Pokemon(pokemonId, pokemonName, pokemonTypeList);
    TimesMarkedAsFavourite numberOfTimesMarkedAsFavourite = favouritePokemonRepository.numberOfTimesMarkedAsFavourite(pokemonId);

    return new PokemonDetails(
        pokemonId.getPokemonId(),
        pokemon.getName().getName(),
        pokemon.getTypes().toStringArrayList(),
        numberOfTimesMarkedAsFavourite.getTimesMarkesAsFavourite()
    );
  }
}
