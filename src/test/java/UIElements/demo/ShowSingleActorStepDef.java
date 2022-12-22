package UIElements.demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

@ScenarioScope
public class ShowSingleActorStepDef {

    @Autowired
    ActorRepository actorrepo;

    int actorid;
    Actor chosenactor;

    @Given("an actor exists with id {int}")
    public void an_actor_actor_exists_with_id(int id){
        actorid = id;
        actorrepo.findById(actorid).orElseThrow(() -> new ResourceAccessException("Actor ID doesn't exist in the DB: " + actorid));
    }

    @When("I request that actors details")
    public void I_request_that_actors_details(){
        chosenactor = actorrepo.findById(actorid).orElseThrow(() -> new ResourceAccessException("Actor ID doesn't exist in the DB: " + actorid));
        Assertions.assertNotEquals(null, chosenactor, "Actor with id: " + actorid + " was not retrieved");
    }

    @Then("the webpage should show the actors {string} and {string}")
    public void the_webpage_should_show_the_actors_firstname_and_lastname(String fname, String lname){
        String correctdetails = fname + " " + lname;
        String testdetails = chosenactor.getFirstname() + " " + chosenactor.getLastname();
        Assertions.assertEquals(correctdetails, testdetails, "The details mismatched");
    }

}
