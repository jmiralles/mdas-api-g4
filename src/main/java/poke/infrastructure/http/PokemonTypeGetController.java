package poke.infrastructure.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import poke.application.usecase.PokemonTypeFinder;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonTypeList;
import poke.domain.PokemonTypeRepository;
import java.util.List;

@RestController
public class PokemonTypeGetController {

  private PokemonTypeFinder pokemonTypeFinder;

  @Autowired
  public PokemonTypeGetController(PokemonTypeRepository pokeApiPokemonTypeRepository) {
    this.pokemonTypeFinder = new PokemonTypeFinder(pokeApiPokemonTypeRepository);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/pokemon-type")
  public List<String> invoke(@RequestParam(value = "id") String id) {
    PokemonId pokemonId = PokemonId.fromString(id);
    PokemonTypeList pokemonTypes = pokemonTypeFinder.invoke(pokemonId);
    return pokemonTypes.toStringArrayList();
  }
}
