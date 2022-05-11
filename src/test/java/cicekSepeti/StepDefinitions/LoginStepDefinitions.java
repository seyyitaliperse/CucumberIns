package cicekSepeti.StepDefinitions;

import cicekSepeti.Pages.BasePage;
import cicekSepeti.Pages.LoginPage;
import cicekSepeti.Utilities.BrowserUtils;
import cicekSepeti.Utilities.ConfigurationReader;
import cicekSepeti.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();
    String globalMail;
    String globalPassword;
    String wrongEmailError ="E-mail address or password is incorrect. Please check your information and try again.";


    // LoginPage içinde ki 'login' methodu ile gerekli mail ve şifre ile sisteme giriş sağlıyoruz.
    @When("user enter valid email {string} and password {string} for sign in")
    public void user_enter_valid_email_with_email_and_password_for_sign_in(String email, String password) {
        globalMail=ConfigurationReader.get(email);
        globalPassword=ConfigurationReader.get(password);
        loginPage.login(email,password);
        BrowserUtils.waitFor(2);

    }

    // Modüllere girmedim. Basitçe en azından title kontrolü sağladım.
    @When("page title should be {string}")
    public void page_title_should_be(String string) {
        Assert.assertEquals(Driver.get().getTitle(),ConfigurationReader.get("basePageTitle"));

    }
    @Then("user log out successfully")
    public void user_log_out_successfully() {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(loginPage.myAccountDropdown).build().perform();
        BrowserUtils.waitFor(1);
        loginPage.logoutButton.click();
        BrowserUtils.waitFor(1);
        Assert.assertEquals(Driver.get().getTitle(),"Mizu - International Flower & Gift Delivery Service");
    }


    @Given("user enter invalid email {string} or password {string} for sign in")
    public void user_enter_wrong_email_or_password_for_sign_in(String email,String password) {
        globalMail=ConfigurationReader.get(email);
        globalPassword=ConfigurationReader.get(password);
        loginPage.invalidLogin(email,password);


    }


    @Given("user should get wrong email or password error message {string}")
    public void user_should_get_wrong_email_or_password_error_message(String expectedErrorMessage) {
        BrowserUtils.waitFor(2);
        String actualErrorMessage = Driver.get().findElement(By.cssSelector("div.modal-body")).getText();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

    }


    @Test
    public void test1(){
        String upper=ConfigurationReader.get("email_boundary_upper_101");
        String middle=ConfigurationReader.get("email_boundary_middle_100");
        String lower=ConfigurationReader.get("email_boundary_lower_99");
        System.out.println("upper = " + upper.length());
        System.out.println("middle = " + middle.length());
        System.out.println("lower = " + lower.length());

    }

    @Given("user navigate to {string}")
    public void userNavigateTo(String url) {
        Driver.get().get(ConfigurationReader.get(url));
        Driver.get().manage().window().maximize();


        }



    @Then("user should get blank {string} warning message")
    public void userShouldGetBlankWarningMessage(String errorMessage) {

        if(globalMail.equals(ConfigurationReader.get("valid_email"))){
            Assert.assertEquals(loginPage.passwordErrorMessage.getText(),errorMessage);
        }else if(globalMail.equals(ConfigurationReader.get("blank"))){
            Assert.assertEquals(loginPage.emailErrorMessage.getText(),errorMessage);
        }else {
            Assert.assertTrue(false);
        }
    }


    @Then("user should get email boundary error {string} message if email has more than {int} character")
    public void userShouldGetEmailBoundaryErrorMessageIfEmailHasMoreThanCharacter(String expectedBoundaryErrorMessage, int charLength) {
        int emailLength=globalMail.length();
        boolean boundaryCondition;
        switch (emailLength){
            case 99:
            case 100:
                BrowserUtils.waitFor(2);
                Assert.assertEquals(Driver.get().findElement(By.cssSelector("div.modal-body")).getText(),wrongEmailError);
                break;
            case 101:
                BrowserUtils.waitFor(2);
                Assert.assertEquals(loginPage.emailErrorMessage.getText(),expectedBoundaryErrorMessage);
                break;
            default:
                System.out.println("Value is not recommended for Boundary Value Analysis");
        }






        }


    @Then("user should get password boundary error {string} message if email is not between {int} to {int}")
    public void userShouldGetPasswordBoundaryErrorMessageIfEmailIsNotBetweenTo(String expectedBoundaryErrorMessage, int minBoundary, int maxBoundary) {
        int passwordLength=globalPassword.length();
        boolean boundaryCondition;
        switch (passwordLength){
            case 3:
            case 4:
            case 19:
            case 20:
                BrowserUtils.waitFor(2);
                Assert.assertEquals(Driver.get().findElement(By.cssSelector("div.modal-body")).getText(),wrongEmailError);
                break;
            case 2:
            case 21:
                BrowserUtils.waitFor(2);
                Assert.assertEquals(loginPage.passwordErrorMessage.getText(),expectedBoundaryErrorMessage);
                break;
            default:
                System.out.println("Value is not recommended for Boundary Value Analysis");
        }
    }
}
