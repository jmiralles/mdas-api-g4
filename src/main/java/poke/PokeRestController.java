package poke;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import poke.exceptions.PokemonNotFoundException;

import java.util.List;

@RestController
public class PokeRestController {
  @RequestMapping(method = RequestMethod.GET, path = "/getTypeOfPokemonById")
  public List<String> getTypeOfPokemonById(@RequestParam(value = "id") String id) throws PokemonNotFoundException {
    PokemonService pokemonService = new PokemonService();
    return pokemonService.getTypesOfPokemonById(Integer.parseInt(id));
  }
}
