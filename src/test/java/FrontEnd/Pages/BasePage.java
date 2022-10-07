package FrontEnd.Pages;

import FrontEnd.Utilities.BrowserUtils;
import FrontEnd.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public abstract class BasePage {

    protected   <T extends WebElement> void writeText(WebElement element,String text){
        BrowserUtils.waitForPageToLoad(Duration.ofSeconds(10));
        element.sendKeys(text);
    }
    protected   <T extends By> String getText(WebElement element){
        BrowserUtils.waitForPageToLoad(Duration.ofSeconds(10));
       return element.getText();
    }
    protected     <T extends By> void click(WebElement element){
        BrowserUtils.waitForVisibility(element, Duration.ofSeconds(10));
        element.click();
    }

    protected String getCurrentUrl(){
        return Driver.get().getCurrentUrl();
    }

    public BasePage() {PageFactory.initElements(Driver.get(), this);  }
}
