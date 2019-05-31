package poke.acceptance;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.assertj.core.util.Lists;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import poke.infrastructure.http.PokemonHttpServer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HTTPStepDefs {
  private HttpURLConnection connection;

  @Given("I am in HTTP application")
  public void iAmInHTTPApplication() {
    PokemonHttpServer.main(new String[]{});
  }

  @When("I send {string} to pokemon-type endpoint")
  public void iSendToPokemonTypeEndpoint(String arg0) throws Exception {
    URL obj = new URL("http://localhost:8080/pokemon-type?id="+arg0);
    connection = (HttpURLConnection) obj.openConnection();
    connection.setRequestMethod("GET");
    assertEquals(200, connection.getResponseCode());
  }

  @Then("I get [{string},{string}]")
  public void iGet(String arg0, String arg1) throws Exception {
    Scanner s = new Scanner(connection.getInputStream()).useDelimiter("\\A");
    String result = s.hasNext() ? s.next() : "";
    assertEquals("[\"" + arg0 + "\",\"" + arg1 + "\"]", result);
  }
}
