package FrontEnd.Pages;

import FrontEnd.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocatorsPage extends BasePage {


    //Functional
    @FindBy(xpath ="//a[@class='tyj39b-5 lfsBU']")
    public WebElement cookies;

    @FindBy(xpath ="//input[@placeholder='Keşfetmeye Bak']")
    public WebElement searchBox;

    @FindBy(xpath ="//button[@type='submit']")
    public WebElement searchSubmitButton;

    @FindBy(xpath = "//h1[@id='sp-title']")
    public WebElement productInformation;

    @FindBy(id = "sp-price-lowPrice")
    public WebElement productLowPricePage;

    @FindBy(id = "sp-price-highPrice")
    public WebElement productHighPrice;

    @FindBy(xpath = "//span[@id='sp-price-discountPercentage']")
    public WebElement discountPercentage;

    @FindBy(xpath = "//button[@id='add-to-basket']")
    public WebElement addToBasketButton;

    @FindBy(xpath = "//p[@class='new-price']")
    public WebElement productLowPriceBasket;

    @FindBy(xpath = "//select[@class='amount']")
    public WebElement productAmountDropdown;

    @FindBy(xpath = "(//i[@class='gg-icon gg-icon-bin-medium'])[1]")
    public WebElement productDelete;

    @FindBy(xpath = "(//h2)[1]")
    public WebElement emptyBasketMessage;

    @FindBy(xpath = "//a[@class='gg-ui-btn-default padding-none']")
    public WebElement basket;

    /**
     For column and row tables it is very useful to create dynamic locator same as below.
     */
    public WebElement pageNumber(String pageNumber){
        return Driver.get().findElement(By.xpath("//span[normalize-space()='"+ pageNumber+"']"));
    }

    public WebElement productIndex(String randomNumber){
        return Driver.get().findElement(By.xpath("//li["+randomNumber+"]//article[1]"));
    }









    }

