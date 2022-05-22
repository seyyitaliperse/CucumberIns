
#-----------------------------------------------------------UI PART ---------------------------------------------------------
#Bascally I write my test scenarios in "Resource/features/frontEndAPI" and I write my scenario codes in /StepDefinitions/FrontEndStepDefinitions and 
#I assign my web elements and methods in LocatorsPage.
I create different packages for dynamic coding, using of OOP effectively.
- Pages: In this package I implement my locators and methods. Normally with Page Object Model I should create separate classes. But I didn't for this project.
- Runner: In this package there is runner classes for trigger our framework for both UI and API part by adress our features and step definitions.
- Features: Contains our scenarios(features). 
- StepDefinitions: Contains our codes for features. In this part also we should use POM structure managing framework easily.
- Utilities: Contains reusable implementations for clean and less cods. 
    Configuration.reader: This parts help us to read our stored data from configuration.properties.

#In features I have used DataTable, Scenario outline for better coding. If I have a time I could do it more and more dynamic. But currently I am working -
# -and for more dynamic properly I have to know company culture. At least you can understand my strategy.

#-----------------------------------------------------------API PART ---------------------------------------------------------
- In API part I didn't go dynamic coding deeply. Maybe it could be hard for understanding of implementations. 
- I didn't do a lot scenario like basic verification things.Because I am currently working and because of I leave I just support some new team members for onboarding process.
- Basically I write my scenarios in "BackEndAPI" feature file and I write my codes in StepDefinitions/ApiStepDefinitions.

#I send "POST" request dynamically, I verify that response exist with "GET" request and I send "DELETE" request for verifying that body data not exist anymore.

#I could do it by using POSTMAN testscript or with Karate framework. I will send one basic sample about that, from my another task. 


##-----------------------------------------------------------JUNIT FRAMEWORK ---------------------------------------------------------
- I didn't use JUNIT because I could not explain myself on it. For JUNIT i need some little onboarding progress actually for understand of your strategy. 
- I hope everything will be okay. If you want me to test more things, I can add some new scenarios. 