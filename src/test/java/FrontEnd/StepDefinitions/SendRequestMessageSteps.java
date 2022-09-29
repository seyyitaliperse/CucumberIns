package FrontEnd.StepDefinitions;


import FrontEnd.Pages.ContactPage;
import FrontEnd.Pages.DashboardPage;
import FrontEnd.Utilities.BrowserUtils;
import FrontEnd.Utilities.ConfigurationReader;
import FrontEnd.Utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SendRequestMessageSteps {
    ContactPage contactPage = new ContactPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("user on the obss base page")
    public void user_on_the_obss_base_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }

    @Given("user navigates to obss contact page")
    public void userNavigatesToObssContactPage() {
        dashboardPage.goToContactUsPage();
    }

    @When("user send a request message to obss")
    public void userSendARequestMessageToObss(DataTable dataTable) {
        List<List<String>> bodyList = dataTable.cells();
        String fullName = bodyList.get(1).get(0);
        String mailAdress = bodyList.get(1).get(1);
        String phoneNumber = bodyList.get(1).get(2);
        String messageText = bodyList.get(1).get(3);
        contactPage.sendRequestMessage(fullName,mailAdress,phoneNumber,messageText);
    }

    @Then("user verifies that successfully get feedback message")
    public void userVerifiesThatSuccessfullyGetFeedbackMessage() throws InterruptedException {
        BrowserUtils.waitForVisibility(contactPage.feedbackMessage, Duration.ofSeconds(10));
        Assert.assertEquals(contactPage.feedbackMessage.getText(),"Thank you for filling out the form! We will contact you shortly!");
        Thread.sleep(3000);
    }
}

