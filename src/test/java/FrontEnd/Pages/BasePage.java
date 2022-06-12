package FrontEnd.Pages;

import FrontEnd.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public abstract class BasePage {
    public BasePage() {PageFactory.initElements(Driver.get(), this);  }

    public static int randomNum(int min,int max){
        Random random = new Random();
        return random.nextInt(max)+min;
    }

    public static void writeProductInfoToTxtFile(String productName, String productPrice){
        String url ="src/test/resources/ProductInformation.txt";
        File file=new File(url);
        try {
            file.createNewFile();
            FileWriter myWriter = new FileWriter( file.getAbsolutePath());

            myWriter.write("Product Information: " + productName + "\nProduct Price: "+ productPrice);
            myWriter.close();
        } catch ( IOException e) {
            e.printStackTrace();}}


    public static void selectDropdownValue(WebElement dropdownElement,String value){
        Select amounthDropdown = new Select(dropdownElement);
        amounthDropdown.selectByValue(value);}

    public static String getSelectedTextDropdown(WebElement dropdownElement){
        Select dropdown = new Select(dropdownElement);
        return dropdown.getFirstSelectedOption().getText();
    }
}
