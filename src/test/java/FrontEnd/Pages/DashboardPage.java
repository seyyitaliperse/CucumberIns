package FrontEnd.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    //TODO Locators under this line
    @FindBy(xpath = "//button[@class='btn button-white waves-effect campton-medium contact-us-form']")
    public WebElement contactUsButton;

    @FindBy(id = "cookieAcceptance")
    public WebElement entranceCookie;



    //TODO Methods under this line
    public void goToContactUsPage(){
        click(entranceCookie);
        click(contactUsButton);
    }
}
