/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package poke.infrastructure.http;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;
import poke.domain.exceptions.PokemonNotFoundException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PokeRestControllerTests {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void paramGreetingShouldReturnTailoredMessage() throws Exception {

    this.mockMvc.perform(get("/pokemon-type").param("id", "1"))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$", is(Lists.newArrayList("poison", "grass"))));
  }

  @Test(expected = NestedServletException.class)
  public void paramGreetingShouldReturnTailoredMessage2() throws Exception {

    this.mockMvc.perform(get("/pokemon-type").param("id", "-1"));
  }

}
