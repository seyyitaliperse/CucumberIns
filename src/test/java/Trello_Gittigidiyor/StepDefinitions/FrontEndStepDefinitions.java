package Trello_Gittigidiyor.StepDefinitions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import Trello_Gittigidiyor.Pages.LocatorsPage;
import Trello_Gittigidiyor.Utilities.BrowserUtils;
import Trello_Gittigidiyor.Utilities.ConfigurationReader;
import Trello_Gittigidiyor.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class FrontEndStepDefinitions {
    LocatorsPage locatorsPage =new LocatorsPage();
    String globalPageNumber;
    String globalProductPrice;
    String globalProductInformation;




    @Given("user navigates to the main page")
    public void user_navigates_to_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();

    }

    @Given("user able to search {string} on search box")
    public void user_able_to_search_on_search_box(String itemName) {
        locatorsPage.cookies.click();
        locatorsPage.searchBox.sendKeys("bilgisayar");
        locatorsPage.searchSubmitButton.click();
        BrowserUtils.waitFor(3);

    }

    @Given("user able to move to {string} page")
    public void user_able_to_move_to_page(String pageNumber) {
        globalPageNumber=pageNumber;
        WebElement page = locatorsPage.pageNumber(pageNumber);
        page.click();
        BrowserUtils.waitFor(4);

    }

    @Then("the page number should be correct")
    public void the_page_number_should_be_correct() {
        String url = Driver.get().getCurrentUrl();
        String actualPageNumber= String.valueOf(url.charAt(url.length()-1));
        Assert.assertEquals(actualPageNumber,globalPageNumber);
    }



    @Then("user able to click on a product")
    public void user_able_to_click_on_a_product() {
        locatorsPage.productIndex("6").click();
        BrowserUtils.waitFor(2);

    }

    @Then("user able to add product to basket")
    public void user_able_to_add_product_to_basket() {
        globalProductPrice       = locatorsPage.productHighPrice.getText();
        globalProductInformation = locatorsPage.productInformation.getText();
        locatorsPage.addToBasketButton.click();
        BrowserUtils.waitFor(1);
        locatorsPage.basket.click();
    }

    @Then("verifying that page product price and basket price should be same")
    public void verifying_that_page_product_price_and_basket_price_should_be_same() {
        Assert.assertEquals(locatorsPage.productLowPriceBasket.getText(),globalProductPrice);
    }

    @Then("user able to improve amount of product as {string}")
    public void user_able_to_improve_amount_of_product_as(String expectedAmounth) {
        Select amounthDropdown = new Select(locatorsPage.productAmountDropdown);
        amounthDropdown.selectByValue(expectedAmounth);
        BrowserUtils.waitFor(2);
        Assert.assertEquals(amounthDropdown.getFirstSelectedOption().getText(),expectedAmounth);
    }

    @Then("user able to delete product from basket")
    public void user_able_to_delete_product_from_basket() {
        locatorsPage.productDelete.click();
        BrowserUtils.waitFor(3);
    }

    @Then("verifying that basket has empty message as {string}")
    public void verifying_that_basket_has_empty_message_as(String expectedEmptyMessage) {
       Assert.assertEquals(locatorsPage.emptyBasketMessage.getText(),expectedEmptyMessage);
    }


}

