#-----------------------------------------------------------FEEDBACK ---------------------------------------------------------
- Firstly I have used Cucumber BDD framework which support UI, API and SQL tests and I implement some UI and API tests.   
- Secondly, from the features files directly you can use it as dynamic but as a requests I didn't do dynamic for understanding better from your side. 
And I added some prints for tracking on the console.
- Thirdly, I have finished immediately because I triggered my notice period and coming days I need to teach our structure to the new QA friends.
- Finally, I want to say that in my current company we are using Cucumber Framework more and more dynamic but it is depends on company, so about dynamic coding I need to get Onboarding Process
and please note that I have only 2 years experience.

#-----------------------------------------------------------UI PART ---------------------------------------------------------
#You can see on "src/test/java/FrontEnd" address there are 4 packages created with OOP concept.
- Pages: In this package I implement my locators and methods. Normally with Page Object Model I should create separate classes. But I didn't for this project.
- Runner: In this package there is runner classes for trigger our framework for both UI and API part by adress our features and step definitions.
- StepDefinitions: Contains our codes for features. In this part also we should use POM structure managing framework easily.
- Utilities: Contains reusable implementations for clean and less cods. 
    Configuration.reader: This parts help us to read our stored data from configuration.properties.
#You can find below the project configuration.properties and on "src/test/FrontEnd/resources" we have our feature files.
- Features: Contains our scenarios(features).
- configuration.properties: Contains our resuable datas.

#-----------------------------------------------------------API PART ---------------------------------------------------------
- In feature files
- Basically I wrote my scenarios in "BackEndAPI", I wrote my codes in ApiStepDefinitions class and I trigger my features from RunnerAPI.
- I didn't do separate Scenarios for https methods because I already implement on one scenario as dynamic. For dynamic coding I define some global variables for passing variables.

#-----------------------------------------------------------REPORTS & FAILED TEST RUNNER---------------------------------------------------------
- REPORTS: In cucumber reports "target/cucumber-html-reports/overview-features" adress you can open with chrome and you can see reports in details.
- FAILED TEST RUNNER: - After trigger "RunnerUI" failed tests will be strored in "target/rerun.txt" adress, once you fix your steps you can just trigger "FailedTestRunner" so I will trigger only failed tests.

#-----------------------------------------------------------Sample Mail&Password---------------------------------------------------------
mail: sample.seyyitaliperse@gmail.com  
password: sampleUser2000




