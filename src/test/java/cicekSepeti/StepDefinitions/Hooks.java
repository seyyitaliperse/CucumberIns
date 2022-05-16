package cicekSepeti.StepDefinitions;

import cicekSepeti.Utilities.ConfigurationReader;
import cicekSepeti.Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


//Befor annotation'u farklılık olması adına Background olarak kullandım. Burda ise işlem sonrası için.
@After
    public void tearDown(){
    Driver.closeDriver();
}

}
