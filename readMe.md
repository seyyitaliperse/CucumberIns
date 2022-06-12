#**FEEDBACK**
1. I have used Cucumber BDD framework which support UI, API and DB tests. 
2. My focus is controlling framework from the features files. It should be dynamic but because of my current work, specially for API side it is not enough dynamic for http methods. It can be dynamic depends on companies. 
3. For report of tests following "target/cucumber-html-reports/overview-features" address you can open with chrome and you can see reports in details. 
4. You can see step logs on the console and under the project "Log4" package.

#**FRONT END(UI)**
You can see on "src/test/java/FrontEnd" address there are 4 packages created with OOP concept.
1. Pages: In this package I implement my locators and methods. Normally with Page Object Model I should create separate classes. But I didn't for this project.
2. Runner: In this package there is runner classes for trigger our framework for both UI and API part by adress our features and step definitions.
3. StepDefinitions: Contains our codes for features. In this part also we should use POM structure managing framework easily.
4. Utilities: Contains reusable implementations for clean and less codes. 
    
You can find below the project configuration.properties and on "src/test/resources" we have our feature files.
5. Features: Contains our scenarios(features).
6. configuration.properties: Contains our resuable datas.

#**API** 
1. Basically I wrote my scenarios in "apiScenarios", I wrote my codes in "API/ApiStepDefinitions" class and I trigger my features from "Runner/RunnerAPI".
2. I didn't do separate Scenarios for https methods because I already implement on one scenario as dynamic. For dynamic coding I define some global variables for passing variables.
3. You can follow test steps from trello board with your own token and key or you can just use prettyprint for responses.

#**SOME NOTES**
1. FAILED TEST RUNNER: After trigger "RunnerUI" failed tests will be stored in "target/rerun.txt" adress, once you fix your steps you can just trigger "FailedTestRunner" so I will trigger only failed tests.

#Sample mail&password
1. Mail: sample.seyyitaliperse@gmail.com  
2. Password: sampleUser2000




