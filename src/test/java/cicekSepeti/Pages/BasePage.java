package cicekSepeti.Pages;

import cicekSepeti.Utilities.BrowserUtils;
import cicekSepeti.Utilities.ConfigurationReader;
import cicekSepeti.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {PageFactory.initElements(Driver.get(), this);  }

    // *************************
    @FindBy(xpath = "(//span[contains(@class,'user-menu__icon user-menu__icon--account icon-user_2')])[2]")
    public WebElement myAccountDropdown;

    @FindBy(xpath = "//div[contains(@class,'header__top js-window-menu')]//a[contains(@title,'Log Out')][normalize-space()='Log Out']")
    public WebElement logoutButton;



    //Temiz kodlama için hazır URL
    public void navigateTo(String url){
        Driver.get().get(ConfigurationReader.get(url));
        Driver.get().manage().window().maximize();
    }

    //
    public void loginMessages(){

    }










}
