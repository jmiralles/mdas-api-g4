package poke.acceptance;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsoleStepDefs {
  @Given("I am in CLI application")
  public void iAmInCLIApplication() {
  }

  @When("I enter {string}")
  public void iEnter(String arg0) {
  }

  @Then("I get {string} in System.out")
  public void iGetInSystemOut(String arg0) {
  }

  @Then("I get error code {string}")
  public void iGetErrorCode(String arg0) {
  }
}
