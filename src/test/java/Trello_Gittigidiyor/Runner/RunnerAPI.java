package Trello_Gittigidiyor.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//We implement our Cucumber runner here.
@RunWith(Cucumber.class)

//We implement our Cucumber properties in here. We show feature and step definitions adress and other things in here.
@CucumberOptions(

        features = "src/test/resources/features/",
        glue = "Trello_Gittigidiyor/StepDefinitions",
        dryRun = false,
        tags = "@apiTest"
)

public class RunnerAPI {
}