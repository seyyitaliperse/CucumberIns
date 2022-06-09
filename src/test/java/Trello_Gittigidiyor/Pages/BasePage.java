package Trello_Gittigidiyor.Pages;

import Trello_Gittigidiyor.Utilities.Driver;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public abstract class BasePage {
    public BasePage() {PageFactory.initElements(Driver.get(), this);  }

    public static int randomNum(int min,int max){
        Random random = new Random();
        return random.nextInt(max)+min;
    }

}
