package poke.infrastructure.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import poke.application.PokemonTypeFinder;
import poke.domain.valueobjects.UserId;

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
  public List<String> invoke(@RequestParam(value = "id") String id) {
    return pokemonTypeFinder.invoke(Integer.parseInt(id));
  }
}