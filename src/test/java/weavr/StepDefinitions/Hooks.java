package weavr.StepDefinitions;

import weavr.Utilities.Driver;
import io.cucumber.java.After;

public class Hooks {


//Befor annotation'u farklılık olması adına Background olarak kullandım. Burda ise işlem sonrası için.
@After
    public void tearDown(){
    Driver.closeDriver();
}

}
