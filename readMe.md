#**FEEDBACK**
1. I have used Cucumber BDD framework which support UI, API and DB tests.
2. My framework strongly uses OOP and POM concept. I have BasePage class as a Abstract Class, so I can hide my implementation and I can inherite my methods and some common locators from this class to my other page classes.
3. My focus is controlling framework from the features files. API part can be more dynamic but it is depends on company strategy.
4. For report of tests following "target/cucumber-html-reports/overview-features" address you can open with chrome and you can see reports in details. 
5. You can see step logs on the console and under the project "Log4" package.

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
1. I wrote API test as extra, so you can understand my API test strategy. 
2. Basically I wrote my scenarios in "apiScenarios", I wrote my codes in "API/ApiStepDefinitions" class and I trigger my features from "Runner/RunnerAPI".
3. I didn't do separate Scenarios for https methods because I already implement on one scenario as dynamic. For dynamic coding I define some global variables for passing variables.
4. You can follow test steps from trello board with your own token and key or you can just use prettyprint for responses.

#**SOME NOTES**
1. FAILED TEST RUNNER: After trigger "RunnerUI" failed tests will be stored in "target/rerun.txt" adress, once you fix your steps you can just trigger "FailedTestRunner" so I will trigger only failed tests.

#Sample mail&password
1. Navigate and login trello website: https://trello.com/
2. Mail: sample.seyyitaliperse@gmail.com  
3. Password: sampleUser2000
#Get "KEY" and "TOKEN" for Configuration.properties (Already implemented)
4. https://trello.com/app-key




