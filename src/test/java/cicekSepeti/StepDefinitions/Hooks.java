package cicekSepeti.StepDefinitions;

import cicekSepeti.Utilities.ConfigurationReader;
import cicekSepeti.Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();

    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }


}
