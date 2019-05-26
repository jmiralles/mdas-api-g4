package poke.infrastructure.http;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import poke.application.GetDetailsOfPokemon;
import poke.domain.PokemonDetails;
import poke.domain.valueobjects.PokemonId;
import poke.infrastructure.repositories.favouritepokemon.InMemoryFavouritePokemonRepository;
import poke.infrastructure.repositories.pokemonname.PokeApiPokemonNameRepository;
import poke.infrastructure.repositories.pokemontype.PokeApiPokemonTypeRepository;

@RestController
public class PokemonDetailsGetController {
  private final GetDetailsOfPokemon getDetailsOfPokemon = new GetDetailsOfPokemon(
      new PokeApiPokemonTypeRepository(),
      new PokeApiPokemonNameRepository(),
      new InMemoryFavouritePokemonRepository()
  );

  @RequestMapping(method = RequestMethod.GET, path = "/pokemon-details")
  public PokemonDetails invoke(@RequestParam(value = "id") String id) {
    PokemonId pokemonId = PokemonId.fromString(id);
    return getDetailsOfPokemon.invoke(pokemonId);
  }
}
