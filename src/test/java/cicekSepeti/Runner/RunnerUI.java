package cicekSepeti.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Burda Runner olarak Cucumber seçimini tanımlıyoruz. Cucumber-junit bağımlılığını kullanıyoruz.
@RunWith(Cucumber.class)


//Burda Cucumber Runner için gerekli parametreleri tanımlıyoruz.
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"},
        features = "src/test/resources/features/",
        glue = "cicekSepeti/StepDefinitions",
        dryRun = false,
        tags = "@apiTest",
        publish = true
)

// SORU !!!!!
public class RunnerUI {
}