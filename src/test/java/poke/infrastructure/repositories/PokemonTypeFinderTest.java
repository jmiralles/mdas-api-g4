package poke.infrastructure.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import poke.application.usecase.PokemonTypeFinder;
import poke.domain.PokemonIdMother;
import poke.domain.PokemonTypeRepository;
import poke.domain.exceptions.PokemonNotFoundException;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonType;
import poke.domain.valueobjects.PokemonTypeList;

import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PokemonTypeFinderTest {
  private PokemonTypeFinder pokemonTypeFinder;
  @Mock
  private PokemonTypeRepository pokemonTypeRepository;

  private final PokemonTypeList VALID_TYPE_OUTPUT = new PokemonTypeList(Collections.singletonList(new PokemonType("output")));

  @Test
  public void getPokemonType_returnsCorrect_WhenPokemonExists() {
    // GIVEN
    PokemonId validPokemonId = PokemonIdMother.generateValidPokemonId();
    when(pokemonTypeRepository.find(validPokemonId)).thenReturn(VALID_TYPE_OUTPUT);
    pokemonTypeFinder = new PokemonTypeFinder(pokemonTypeRepository);

    // WHEN
    PokemonTypeList actualResult = pokemonTypeFinder.invoke(validPokemonId);

    // THEN
    assertThat(actualResult, is(VALID_TYPE_OUTPUT));
    verify(pokemonTypeRepository, times(1)).find(validPokemonId);
  }

  @Test
  public void getPokemonType_throwsException_WhenPokemonDoesNotExists() {
    // GIVEN
    PokemonId inValidPokemonId = PokemonIdMother.generateInvalidPokemonId();
    when(pokemonTypeRepository.find(inValidPokemonId)).thenThrow(new PokemonNotFoundException());
    pokemonTypeFinder = new PokemonTypeFinder(pokemonTypeRepository);

    // THEN
    assertThrows(PokemonNotFoundException.class, () -> pokemonTypeFinder.invoke(inValidPokemonId));
    verify(pokemonTypeRepository, times(1)).find(inValidPokemonId);
  }
}
