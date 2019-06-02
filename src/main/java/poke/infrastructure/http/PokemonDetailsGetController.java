package poke.infrastructure.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import poke.application.usecase.GetDetailsOfPokemon;
import poke.domain.PokemonDetails;
import poke.domain.valueobjects.PokemonId;
import poke.domain.PokemonNameRepository;
import poke.domain.PokemonTypeRepository;
import poke.domain.FavouritePokemonRepository;

@RestController
public class PokemonDetailsGetController {

  private GetDetailsOfPokemon getDetailsOfPokemon;

  @Autowired
  public PokemonDetailsGetController(
          PokemonTypeRepository PokeApiPokemonTypeRepository,
          PokemonNameRepository PokeApiPokemonNameRepository,
          FavouritePokemonRepository InMemoryFavouritePokemonRepository
  ) {
    this.getDetailsOfPokemon = new GetDetailsOfPokemon(
            PokeApiPokemonTypeRepository,
            PokeApiPokemonNameRepository,
            InMemoryFavouritePokemonRepository
    );
  }

  @RequestMapping(method = RequestMethod.GET, path = "/pokemon-details")
  public PokemonDetails invoke(@RequestParam(value = "id") String id) {
    PokemonId pokemonId = PokemonId.fromString(id);
    return getDetailsOfPokemon.invoke(pokemonId);
  }
}
