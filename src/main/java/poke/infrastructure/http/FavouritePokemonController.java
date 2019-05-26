package poke.infrastructure.http;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import poke.application.AddFavouritePokemon;
import poke.domain.valueobjects.PokemonIdList;
import poke.domain.valueobjects.UserId;
import poke.infrastructure.repositories.favouritepokemon.InMemoryFavouritePokemonRepository;

import java.util.List;

@RestController
public class FavouritePokemonController {
  private final AddFavouritePokemon addFavouritePokemon = new AddFavouritePokemon(new InMemoryFavouritePokemonRepository());

  @RequestMapping(method = RequestMethod.GET, path = "/add-favourite-pokemon")
  public void invoke(@RequestParam(value = "userId") String userId, @RequestParam(value = "pokemonIds") List<String> pokemonIds) {
    PokemonIdList pokemonIdList = PokemonIdList.fromStringListOfPokemonIds(pokemonIds);
    UserId userIdObject = new UserId(userId);
    addFavouritePokemon.invoke(userIdObject, pokemonIdList);
  }
}
