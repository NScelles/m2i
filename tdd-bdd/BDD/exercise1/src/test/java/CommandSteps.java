import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Command;
import org.junit.Assert;

import java.util.List;

public class CommandSteps {

    private Command command;

    @Given("Customer {string} who want to command for Someone")
    public void customerWhoWantToCommandForSomeone(String name){
        command = new Command();
        command.setFrom(name);
    }

    @When("a command is make for Someone")
    public void aCommandIsMakeForSomeone(){
        command.setTo("Tata");
    }

    @And("a product is add in the command")
    public void aProductIsAddInTheCommand(){
        command.setProducts(List.of("ed'rfyhl"));
    }

    @Then("there is no product in the Command")
    public void thereIsNoProductInTheCommand(){
        Assert.assertTrue(command.getProducts().isEmpty());
    }

    @Then("there is one product in the Command")
    public void thereIsOneProductInTheCommand(){
        Assert.assertEquals(1,command.getProducts().size());
    }

    @And("the command come from Customer {string}")
    public void theCommandComeFromCustomer(String name){
        Assert.assertEquals(name,command.getFrom());
    }







}