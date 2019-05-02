package poke;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PokemonTypeFinderTest {
  private PokemonTypeFinder pokemonTypeFinder;
  @Mock
  private PokemonTypeRepository pokemonTypeRepository;

  private final int VALID_POKEMON_ID = 1;
  private final List<String> VALID_TYPE_OUTPUT = Collections.singletonList("output");

  @Test
  public void getPokemonType_returnsCorrect_WhenPokemonExists() {
    when(pokemonTypeRepository.find(VALID_POKEMON_ID)).thenReturn(VALID_TYPE_OUTPUT);

    pokemonTypeFinder = new PokemonTypeFinder(pokemonTypeRepository);
    List<String> actualResult = pokemonTypeFinder.invoke(VALID_POKEMON_ID);
    verify(pokemonTypeRepository, times(1)).find(VALID_POKEMON_ID);
    assertThat(actualResult, is(VALID_TYPE_OUTPUT));
  }
}
