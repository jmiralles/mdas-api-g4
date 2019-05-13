package poke.infrastructure.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import poke.domain.PokemonTypeRepository;
import poke.infrastructure.repositories.pokemontype.InMemoryCachePokemonTypeRepository;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InMemoryCachePokemonTypeRepositoryTest {
  @Mock
  private PokemonTypeRepository pokemonTypeRepository;
  private InMemoryCachePokemonTypeRepository inMemoryCachePokemonTypeRepository;

  @Test
  public void find_ShouldCallPokemonRepository_WhenPokemonIdNotFoundInCache() {
    int pokemonId = 1;
    List<String> pokemonTypes = Collections.singletonList("output");
    when(pokemonTypeRepository.find(pokemonId)).thenReturn(pokemonTypes);
    inMemoryCachePokemonTypeRepository = new InMemoryCachePokemonTypeRepository(pokemonTypeRepository);

    List<String> expectedPokemonTypes = inMemoryCachePokemonTypeRepository.find(pokemonId);
    assertThat(expectedPokemonTypes, is(pokemonTypes));
    verify(pokemonTypeRepository, times(1)).find(pokemonId);
  }

  @Test
  public void find_ShouldNotCallPokemonRepository_WhenPokemonIdFoundInCache() {
    int pokemonId = 1;
    List<String> pokemonTypes = Collections.singletonList("output");
    when(pokemonTypeRepository.find(pokemonId)).thenReturn(pokemonTypes);
    inMemoryCachePokemonTypeRepository = new InMemoryCachePokemonTypeRepository(pokemonTypeRepository);

    inMemoryCachePokemonTypeRepository.find(pokemonId);
    List<String> expectedPokemonTypes = inMemoryCachePokemonTypeRepository.find(pokemonId);
    assertThat(expectedPokemonTypes, is(pokemonTypes));
    verify(pokemonTypeRepository, times(1)).find(pokemonId);
  }
}