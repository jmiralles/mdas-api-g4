package poke.infrastructure.http;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import poke.application.PokemonTypeFinder;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonType;
import poke.infrastructure.repositories.pokemontype.PokeApiPokemonTypeRepository;

import java.util.List;

@RestController
public class PokemonTypeGetController {
  private final PokemonTypeFinder pokemonTypeFinder = new PokemonTypeFinder(new PokeApiPokemonTypeRepository());

  @RequestMapping(method = RequestMethod.GET, path = "/pokemon-type")
  public List<PokemonType> invoke(@RequestParam(value = "id") String id) {
    PokemonId pokemonId = new PokemonId(Integer.parseInt(id));
    return pokemonTypeFinder.invoke(pokemonId);
  }
}
