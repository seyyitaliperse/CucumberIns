package FrontEnd.StepDefinitions;

import FrontEnd.Pages.SauceLabLoginPage;
import FrontEnd.Utilities.ConfigurationReader;
import FrontEnd.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSauceLabSteps {

    SauceLabLoginPage sauceLabLoginPage = new SauceLabLoginPage();
    @Given("user navigates to sauceLab login page")
    public void user_on_the_obss_base_page() {
        Driver.get().get(ConfigurationReader.get("urlSauce"));
    }

    @When("user try to login with {string}  and {string}")
    public void userTryToLoginWithAnd(String username, String password) {
        sauceLabLoginPage.loginWith(username,password);
    }

    @Then("user verifies that successfully logged in")
    public void userVerifiesThatSuccessfullyLoggedIn() {
        Assert.assertEquals(sauceLabLoginPage.currentUrl(),"https://www.saucedemo.com/inventory.html");
    }
}
