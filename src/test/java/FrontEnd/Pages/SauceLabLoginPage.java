package FrontEnd.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceLabLoginPage extends BasePage {


    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    private void enterUsername(String mailAdress){
        writeText(userNameInput,mailAdress);
    }
    private void enterPassword(String mailAdress){
        writeText(passwordInput,mailAdress);
    }

    private void clickLoginButton(){
        click(loginButton);
    }

    public String currentUrl(){
        return getCurrentUrl();
    }

    public void loginWith(String userName, String password){
        enterUsername(userName);
        enterPassword(password);
        clickLoginButton();
    }

}
