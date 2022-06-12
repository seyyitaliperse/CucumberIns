package FrontEnd.StepDefinitions;

import FrontEnd.Pages.BasePage;
import FrontEnd.Pages.LocatorsPage;
import FrontEnd.Utilities.ConfigurationReader;
import FrontEnd.Utilities.Driver;
import FrontEnd.Utilities.Log4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import static FrontEnd.Utilities.BrowserUtils.waitFor;

import java.util.HashMap;
import java.util.Map;


public class FrontEndStepDefinitions {
    LocatorsPage locatorsPage =new LocatorsPage();
    String globalPageNumber;
    Map<String,Object> productInformationMap = new HashMap<>();

    @Given("user navigates to the main page")
    public void user_navigates_to_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();
        Log4j.info("Navigates to web page successfully");}


    @Given("user search for {string} on search engine")
    public void user_able_to_search_on_search_box(String itemName) {
        locatorsPage.cookies.click();
        locatorsPage.searchBox.sendKeys(itemName);
        locatorsPage.searchSubmitButton.click();
        Log4j.info("Searched for " + itemName);
        waitFor(5);}

    @Given("user navigate to page {string} on listed product page")
    public void user_able_to_move_to_page(String pageNumber) {
        globalPageNumber=pageNumber;
        locatorsPage.pageNumber(pageNumber).click();
        waitFor(4);}

    @Then("the page number should be correct")
    public void the_page_number_should_be_correct() {
        String url = Driver.get().getCurrentUrl();
        String actualPageNumber= String.valueOf(url.charAt(url.length()-1));
        Assert.assertEquals(actualPageNumber,globalPageNumber);}

    @Then("user clicks on a random product then adds to basket")
    public void user_clicks_on_a_random_product_then_adds_to_basket() {
        locatorsPage.productIndex(String.valueOf(BasePage.randomNum(1,30))).click();
        waitFor(2);
        productInformationMap.put("ProductPrice",locatorsPage.productHighPrice.getText());
        productInformationMap.put("ProductInformation",locatorsPage.productInformation.getText());
        Log4j.info("Product data is saved.");
        BasePage.writeProductInfoToTxtFile(productInformationMap.get("ProductInformation").toString(),productInformationMap.get("ProductPrice").toString());
        locatorsPage.addToBasketButton.click();
        Log4j.info("Product added to basket.");}


    @Then("user navigates to basket module")
    public void user_navigates_to_basket_module() {
        waitFor(1);
        locatorsPage.basket.click();
        waitFor(4);
        Log4j.info("Navigated to basket page.");}


    @Then("verifying that page product price and basket price should be same")
    public void verifying_that_page_product_price_and_basket_price_should_be_same() {
        Assert.assertEquals(locatorsPage.productLowPriceBasket.getText(),productInformationMap.get("ProductPrice").toString());}

    @Then("user improves amount of product as {string}")
    public void user_able_to_improve_amount_of_product_as(String expectedAmounth) {
        BasePage.selectDropdownValue(locatorsPage.productAmountDropdown,expectedAmounth);
        waitFor(2);
        Log4j.info("Product amount improved as "+ expectedAmounth +".");
        Assert.assertEquals(BasePage.getSelectedTextDropdown(locatorsPage.productAmountDropdown),expectedAmounth);}

    @Then("user deletes product from basket")
    public void user_deletes_product_from_basket() {
        locatorsPage.productDelete.click();
        Log4j.info("Product deleted from basket.");
        waitFor(3);}

    @Then("verifying that basket has empty message as {string}")
    public void verifying_that_basket_has_empty_message_as(String expectedEmptyMessage) {
       Assert.assertEquals(locatorsPage.emptyBasketMessage.getText(),expectedEmptyMessage);}

}

