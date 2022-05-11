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



    // LoginPage içinde ki 'login' methodu ile gerekli mail ve şifre ile sisteme giriş sağlıyoruz.
    @When("user login with email {string} and password {string}")
    public void user_login_with_email_and_password(String email, String password) {
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


    @Given("user sing in with invalid email {string} or password {string}")
    public void user_sing_in_with_invalid_email_or_password(String email,String password) {
        loginPage.invalidLogin(email,password);
        globalMail=ConfigurationReader.get(email);
        globalPassword=ConfigurationReader.get(password);

    }


    @Given("user should get wrong email or password error message {string}")
    public void user_should_get_wrong_email_or_password_error_message(String expectedErrorMessage) {
        BrowserUtils.waitFor(2);
        String actualErrorMessage = Driver.get().findElement(By.cssSelector("div.modal-body")).getText();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

    }


    @Test
    public void test1(){
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();


        loginPage.emailBox.sendKeys(ConfigurationReader.get("valid_email"));
        loginPage.passwordBox.sendKeys("asdjasjd");
        loginPage.singInButton.click();
        BrowserUtils.waitFor(2);

        String a = Driver.get().findElement(By.cssSelector("div.modal-body")).getText();
        System.out.println(a);

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





}
