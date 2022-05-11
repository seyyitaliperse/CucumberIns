package cicekSepeti.Pages;

import cicekSepeti.Utilities.BrowserUtils;
import cicekSepeti.Utilities.ConfigurationReader;
import cicekSepeti.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {



    @FindBy(id = "EmailLogin")
    public WebElement emailBox;

    @FindBy(id = "Password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg pull-right login__btn js-login-button']")
    public WebElement singInButton;

    @FindBy(id = "EmailLogin-error")
    public WebElement emailErrorMessage;

    @FindBy(xpath = "//div[@class='modal-body']")
    public WebElement wrongEmailOrPasswordErrorAlert;

    @FindBy(id = "Password-error")
    public WebElement passwordErrorMessage;

    @FindBy(id = "EmailLogin-error")
    public WebElement blankEmail;



    public void login(String email, String password){
        emailBox.sendKeys(ConfigurationReader.get(email));
        passwordBox.sendKeys(ConfigurationReader.get(password));
        singInButton.click();

        //************** SAYFA GÖRÜNMÜYOR
        BrowserUtils.waitFor(2);
        Driver.get().navigate().refresh();
    }

    public void invalidLogin(String email, String password){
        emailBox.sendKeys(ConfigurationReader.get(email));
        passwordBox.sendKeys(ConfigurationReader.get(password));
        singInButton.click();

    }









}
