package poke.infrastructure.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import poke.application.PokemonTypeFinder;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonType;

import java.util.List;

@RestController
public class FavouritePokemonController {

  @Autowired
  @Qualifier("pokeType")
  private final PokemonTypeFinder pokemonTypeFinder;

  public FavouritePokemonController(PokemonTypeFinder pokemonTypeFinder) {
    this.pokemonTypeFinder = pokemonTypeFinder;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/pokemon-type")
  public List<PokemonType> invoke(@RequestParam(value = "id") String id) {
    PokemonId pokemonId = new PokemonId(Integer.parseInt(id));
    return pokemonTypeFinder.invoke(pokemonId);
  }
}