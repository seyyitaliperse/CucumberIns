package FrontEnd.Pages;

import FrontEnd.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

    //TODO Locators will be under this line

    @FindBy(xpath = "//input[@id='crm_field_4_1']")
    private WebElement nameAndSurnameBox;

    @FindBy(xpath = "//input[@id='crm_field_4_2']")
    private WebElement mailBox;

    @FindBy(xpath = "//input[@id='crm_field_4_3']")
    private WebElement phoneNumberBox;

    @FindBy(xpath = "//textarea[@id='crm_field_4_4']")
    private WebElement requestMessageBox;

    @FindBy(xpath = "//button[@id='crm_field_4_6']")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@class='cfx_thanks_msg cfx_msg_div']//div")
    public WebElement feedbackMessage;

    //TODO Basic methods will be under this line

    private void enterNameSurnameBox(String fullName){
        writeText(nameAndSurnameBox,fullName);
    }
    private void enterMailBox(String mailAdress){
        writeText(mailBox,mailAdress);
    }
    private void enterPhoneNumberBox(String phoneNumber){
        writeText(phoneNumberBox,phoneNumber);
    }
    private void enterRequestMessageBox(String message){
        writeText(requestMessageBox,message);
    }
    private void clickSendButton(){
        click(sendButton);
    }

    //TODO Over methods will be under this line
    public void sendRequestMessage(String fullName, String mailAdress, String phoneNumber, String message){
        enterNameSurnameBox(fullName);
        enterMailBox(mailAdress);
        enterPhoneNumberBox(phoneNumber);
        enterRequestMessageBox(message);
        clickSendButton();
    }
    
}
