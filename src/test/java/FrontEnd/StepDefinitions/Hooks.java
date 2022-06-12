package FrontEnd.StepDefinitions;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import FrontEnd.Utilities.Driver;
import io.cucumber.java.After;

public class Hooks {


//Befor annotation'u farklılık olması adına Background olarak kullandım. Burda ise işlem sonrası için.


    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();
    }

}


