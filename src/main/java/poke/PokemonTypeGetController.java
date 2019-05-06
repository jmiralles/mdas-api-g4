package poke;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokemonTypeGetController {
  private final PokemonTypeFinder pokemonTypeFinder;

  public PokemonTypeGetController(PokemonTypeFinder pokemonTypeFinder) {
    this.pokemonTypeFinder = pokemonTypeFinder;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/pokemon-type")
  public List<String> invoke(@RequestParam(value = "id") String id) {
    return pokemonTypeFinder.invoke(Integer.parseInt(id));
  }
}