package BrandWatch.StepDefinitions;

import io.cucumber.datatable.DataTable;
import org.testng.annotations.Test;
import BrandWatch.Pages.LocatorsPage;
import BrandWatch.Utilities.BrowserUtils;
import BrandWatch.Utilities.ConfigurationReader;
import BrandWatch.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class FrontEndStepDefinitions {
    LocatorsPage locatorsPage =new LocatorsPage();

    @Given("user navigates to the login page")
    public void user_navigates_to_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();
    }
    @Given("user login with username as {string} and password as {string}")
    public void user_fills_the_email_box_as_and_password_box_as(String username, String password) {
        BrowserUtils.waitFor(1);
        locatorsPage.login(username,password);
        BrowserUtils.waitFor(1);

    }
    @Given("page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String actualTitle= Driver.get().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Then("user log out successfully")
    public void user_log_out_successfully() {
        locatorsPage.burgerMenu.click();
        BrowserUtils.waitFor(1);
        locatorsPage.logoutButton.click();
    }

    @Given("user fills the email box as {string} and password box as {string}")
    public void userFillsTheEmailBoxAsAndPasswordBoxAs(String username, String password) {
        locatorsPage.login(username,password);
        BrowserUtils.waitFor(1);
    }

    @Then("user should get error message as {string}")
    public void userShouldGetErrorMessageAs(String expectedErrorMessage) {
        BrowserUtils.waitFor(1);
        String actualErrorMessage = locatorsPage.wrongLoginErrorMessage.getText();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }

    //Actually i could do some dynamic code, I could use string manipulation for web element with switch case. But hope explanation is enough for now.
    @Given("user add some items to the chart")
    public void user_add_some_items_to_the_chart() {
        locatorsPage.backPackProducts.click();
        locatorsPage.boltTtshirtProducts.click();
    }

    @Then("user should able to go for check out")
    public void user_should_able_to_go_for_check_out() {
        locatorsPage.chartModule.click();
        locatorsPage.checkOutBUtton.click();
    }

    //Data Table
    @Then("user fills out necessary inputs")
    public void user_fills_out_necessary_inputs(DataTable dataTable) {
        List<List<String>> dataList = dataTable.cells();
        locatorsPage.firstNameCheckout.sendKeys(dataList.get(1).get(0));
        locatorsPage.lastNameCheckout.sendKeys(dataList.get(1).get(1));
        locatorsPage.postalCodeCheckout.sendKeys(dataList.get(1).get(2));
    }

    @Then("user complete order and get successful message as {string}")
    public void user_complete_order_and_get_successful_message_as(String expectedMessage) {
        locatorsPage.continueButton.click();
        locatorsPage.finishButton.click();
        String actualMessage = locatorsPage.completedOrderMessage.getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void test1(){
        Driver.get().get("https://www.inventanalytics.com/contact-us/");

    }
}

