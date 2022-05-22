package weavr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocatorsPage extends BasePage {


    //Functional
    @FindBy(id ="user-name")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement chartModule;

    @FindBy(id = "checkout")
    public WebElement checkOutBUtton;

    @FindBy(id = "first-name")
    public WebElement firstNameCheckout;

    @FindBy(id = "last-name")
    public WebElement lastNameCheckout;

    @FindBy(id = "postal-code")
    public WebElement postalCodeCheckout;

    @FindBy(id = "continue")
    public WebElement continueButton;

    //Verification
    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement wrongLoginErrorMessage;

    @FindBy(xpath = "//h2[@class='complete-header']")
    public WebElement completedOrderMessage;

    //Products
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement backPackProducts;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement boltTtshirtProducts;

    @FindBy(xpath = "//div[@class=\"inventory_item_name\"]")
    public WebElement inventoryItemsLastCheck;

    @FindBy(id = "finish")
    public WebElement finishButton;

    //Logout
    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenu;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;



    public void login(String email,String password){
        usernameBox.sendKeys(email);
        passwordBox.sendKeys(password);
        loginButton.click();
    }




    }

