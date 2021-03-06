package poke.infrastructure.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import poke.domain.PokemonIdMother;
import poke.domain.PokemonTypeRepository;
import poke.domain.valueobjects.PokemonId;
import poke.domain.valueobjects.PokemonType;
import poke.domain.valueobjects.PokemonTypeList;
import poke.infrastructure.repositories.pokemontype.InMemoryCachePokemonTypeRepository;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InMemoryCachePokemonTypeRepositoryTest {
  @Mock
  private PokemonTypeRepository pokemonTypeRepository;
  private InMemoryCachePokemonTypeRepository inMemoryCachePokemonTypeRepository;
  private PokemonTypeList pokemonTypes = new PokemonTypeList(Collections.singletonList(new PokemonType("output")));

  @Test
  public void find_ShouldCallPokemonRepository_WhenPokemonIdNotFoundInCache() {
    PokemonId pokemonId = PokemonIdMother.generateValidPokemonId();
    when(pokemonTypeRepository.find(pokemonId)).thenReturn(pokemonTypes);
    inMemoryCachePokemonTypeRepository = new InMemoryCachePokemonTypeRepository(pokemonTypeRepository);

    PokemonTypeList actualPokemonTypes = inMemoryCachePokemonTypeRepository.find(pokemonId);
    assertThat(actualPokemonTypes, is(pokemonTypes));
    verify(pokemonTypeRepository, times(1)).find(pokemonId);
  }

  @Test
  public void find_ShouldNotCallPokemonRepository_WhenPokemonIdFoundInCache() {
    PokemonId pokemonId = PokemonIdMother.generateValidPokemonId();
    when(pokemonTypeRepository.find(pokemonId)).thenReturn(pokemonTypes);
    inMemoryCachePokemonTypeRepository = new InMemoryCachePokemonTypeRepository(pokemonTypeRepository);

    inMemoryCachePokemonTypeRepository.find(pokemonId);
    PokemonTypeList actualPokemonTypes = inMemoryCachePokemonTypeRepository.find(pokemonId);
    assertThat(actualPokemonTypes, is(pokemonTypes));
    verify(pokemonTypeRepository, times(1)).find(pokemonId);
  }
}