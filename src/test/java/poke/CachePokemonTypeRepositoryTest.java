package poke;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CachePokemonTypeRepositoryTest {
  @Mock
  private PokemonTypeRepository pokemonTypeRepository;
  private CachePokemonTypeRepository cachePokemonTypeRepository;

  @Test
  public void find_ShouldCallPokemonRepository_WhenPokemonIdNotFoundInCache() {
    int pokemonId = 1;
    List<String> pokemonTypes = Collections.singletonList("output");
    when(pokemonTypeRepository.find(pokemonId)).thenReturn(pokemonTypes);
    cachePokemonTypeRepository = new CachePokemonTypeRepository(pokemonTypeRepository);

    List<String> expectedPokemonTypes = cachePokemonTypeRepository.find(pokemonId);
    assertThat(expectedPokemonTypes, is(pokemonTypes));
    verify(pokemonTypeRepository, times(1)).find(pokemonId);
  }
}