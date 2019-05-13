package poke.infrastructure.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import poke.application.PokemonTypeFinder;
import poke.domain.PokemonTypeRepository;
import poke.domain.exceptions.PokemonNotFoundException;
import poke.domain.valueobjects.PokemonId;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PokemonTypeFinderTest {
  private PokemonTypeFinder pokemonTypeFinder;
  @Mock
  private PokemonTypeRepository pokemonTypeRepository;

  private final PokemonId VALID_POKEMON_ID = new PokemonId(1);
  private final PokemonId INVALID_POKEMON_ID = new PokemonId(-1);
  private final List<String> VALID_TYPE_OUTPUT = Collections.singletonList("output");

  @Test
  public void getPokemonType_returnsCorrect_WhenPokemonExists() {
    // GIVEN
    when(pokemonTypeRepository.find(VALID_POKEMON_ID)).thenReturn(VALID_TYPE_OUTPUT);
    pokemonTypeFinder = new PokemonTypeFinder(pokemonTypeRepository);

    // WHEN
    List<String> actualResult = pokemonTypeFinder.invoke(VALID_POKEMON_ID);

    // THEN
    assertThat(actualResult, is(VALID_TYPE_OUTPUT));
    verify(pokemonTypeRepository, times(1)).find(VALID_POKEMON_ID);
  }

  @Test
  public void getPokemonType_throwsException_WhenPokemonDoesNotExists() {
    // GIVEN
    when(pokemonTypeRepository.find(INVALID_POKEMON_ID)).thenThrow(new PokemonNotFoundException());
    pokemonTypeFinder = new PokemonTypeFinder(pokemonTypeRepository);

    // THEN
    assertThrows(PokemonNotFoundException.class, () -> pokemonTypeFinder.invoke(INVALID_POKEMON_ID));
    verify(pokemonTypeRepository, times(1)).find(INVALID_POKEMON_ID);
  }
}
