package FrontEnd.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//We implement our Cucumber runner here.
@RunWith(Cucumber.class)


//We implement our Cucumber properties in here. We show feature and step definitions adress and other things in here.
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features/",
        glue = "FrontEnd/StepDefinitions",
        dryRun = false,
        tags = "@negative or @positive",
        strict = true
)

public class RunnerUI {
}