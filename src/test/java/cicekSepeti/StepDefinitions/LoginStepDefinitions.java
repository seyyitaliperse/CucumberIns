package cicekSepeti.StepDefinitions;

import cicekSepeti.Pages.LoginPage;
import cicekSepeti.Utilities.BrowserUtils;
import cicekSepeti.Utilities.ConfigurationReader;
import cicekSepeti.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class LoginStepDefinitions {

    //Adımlar arası pass parameter için global değişkenler tanımladım.
    LoginPage loginPage = new LoginPage();
    public static String globalMail;
    public static String globalPassword;
    public static String globalErrorText;
    String wrongEmailError ="E-mail address or password is incorrect. Please check your information and try again.";

    //
    @When("user fills the email box as {string} and password box as {string}")
    public void user_logs_in_by_using_as_email_and_as_password(String email, String password) {
        globalMail = ConfigurationReader.get(email);
        globalPassword = ConfigurationReader.get(password);
        loginPage.login(email, password);
        BrowserUtils.waitFor(2);
    }


    @When("page title should be {string}")
    public void page_title_should_be(String string) {
        Assert.assertEquals(Driver.get().getTitle(),ConfigurationReader.get("basePageTitle")); }

    @Then("user log out successfully")
    public void user_log_out_successfully() {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(loginPage.myAccountDropdown).build().perform();
        BrowserUtils.waitFor(1);
        loginPage.logoutButton.click();
        BrowserUtils.waitFor(1);
        Assert.assertEquals(Driver.get().getTitle(),"Mizu - International Flower & Gift Delivery Service");}

    @Given("user should get error message as {string}")
    public void user_should_get_error_message_as(String expectedErrorText) {
        String actualErrorText = loginPage.errorText(expectedErrorText);
        Assert.assertEquals(actualErrorText,expectedErrorText); }

    @Given("user navigates to the login page")
    public void userNavigatesToTheLoginPage() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize(); }

    @Then("user should get boundary error message as {string} message if email is not between {int} to {int}")
    public void userShouldGetBoundaryErrorTextAsMessageIfEmailIsNotBetweenTo(String errorText , int min , int max) {
            globalErrorText = errorText;
            String actualErrorText = loginPage.boundaryTest(globalErrorText, min, max);
            Assert.assertEquals(actualErrorText, globalErrorText);

    }
}
