package poke.acceptance;

import com.ginsberg.junit.exit.ExpectSystemExitWithStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import poke.infrastructure.console.PokemonTypeFinderCliController;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class ConsoleStepDefs {
  private Function<String[], Void> application;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Given("I am in CLI application")
  public void iAmInCLIApplication() {
    application = (args) -> {
      PokemonTypeFinderCliController.main(args);
      return null;
    };
    System.setOut(new PrintStream(outContent));
  }

  @When("I enter {string}")
  @ExpectSystemExitWithStatus(1)
  public void iEnter(String arg0) {
    application.apply(new String[] {arg0});
  }

  @Then("I get {string} in System.out")
  public void iGetInSystemOut(String arg0) {
    assertEquals(arg0, outContent.toString().trim());
  }

  @Then("I get error code 1")
  @ExpectSystemExitWithStatus(1)
  public void iGetErrorCode1() {

  }
}
