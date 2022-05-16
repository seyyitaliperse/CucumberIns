package cicekSepeti.Pages;

import cicekSepeti.StepDefinitions.LoginStepDefinitions;
import cicekSepeti.Utilities.BrowserUtils;
import cicekSepeti.Utilities.ConfigurationReader;
import cicekSepeti.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
        BrowserUtils.waitFor(2);
        //************** SAYFA GÖRÜNMÜYOR
        }


    public String errorText(String expectedErrorText){
        String actualErrorText="";
        switch (expectedErrorText){
            case "E-mail address or password is incorrect. Please check your information and try again.":
               actualErrorText= Driver.get().findElement(By.cssSelector("div.modal-body")).getText();
               break;

            case "Required field.":
                   if(LoginStepDefinitions.globalMail.equals(ConfigurationReader.get("valid_email"))){
                      actualErrorText=passwordErrorMessage.getText();
                   }else if(LoginStepDefinitions.globalMail.equals(ConfigurationReader.get("blank"))){
                     actualErrorText=emailErrorMessage.getText();
                   }else {
                       Assert.fail();}
                   break;
            case "Please enter a valid e-mail address.":
                actualErrorText=emailErrorMessage.getText();
        break;
            default:
                System.out.println("There is no such error text");}

        return actualErrorText;
    }

    public String boundaryTest(String errorText,int min,int max){
        int emailLength= LoginStepDefinitions.globalMail.length();
        int passwordLength= LoginStepDefinitions.globalPassword.length();
        String actualErrorText="";

        switch (errorText){
            case "'Email' must be between 0 and 100 characters.":
                if (emailLength==max-1 || emailLength==max) {
                    LoginStepDefinitions.globalErrorText= "E-mail address or password is incorrect. Please check your information and try again.";
                    BrowserUtils.waitFor(2);
                    actualErrorText=Driver.get().findElement(By.cssSelector("div.modal-body")).getText();
                }else if(emailLength==max+1){
                    BrowserUtils.waitFor(2);
                    actualErrorText=emailErrorMessage.getText();
                }else {
                    System.out.println("Value is not recommended for Boundary Value Analysis");
                }
                break;

            case "Please enter minimum 3 and maximum 20 characters.":
                if(passwordLength==min || passwordLength==min+1 || passwordLength==max-1 || passwordLength==max){
                    LoginStepDefinitions.globalErrorText= "E-mail address or password is incorrect. Please check your information and try again.";
                    BrowserUtils.waitFor(2);
                    actualErrorText=Driver.get().findElement(By.cssSelector("div.modal-body")).getText();

                }else if (passwordLength==min-1 || passwordLength==max+1){
                    BrowserUtils.waitFor(2);
                    actualErrorText=passwordErrorMessage.getText();
                }
                break;
            default:
                System.out.println("Value is not recommended for Boundary Value Analysis");
        }
        return actualErrorText;
    }
}
