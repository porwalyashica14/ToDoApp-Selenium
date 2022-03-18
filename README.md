#ToDo Application 

Selenium Test Automation Suite

####Tech Stack Used
```
selenium-java version 4.1.2
testng version 6.10
extentreports-testng-adapter version 1.2.2
maven version 3.8.5
java version 1.8.0_231
chrome driver version 99.X
```

####Details on project structure
```
In this project selenium-java is used to test the ToDO application on chrome browser. Most of the code of this project is developed in such a way that it can be easily reused if more screens are present in application. 

An testng.xml configuration file is created to maintain the Automation Suite and it can be found in root folder of the project.

testng.xml  - This file contains the suite and the class for which tests needs to be executed. An parameter is 
defined as browserName which can be passed from every test tag of testng.xml. In case if tests needs to be 
executed for different browsers then another test tag can be created with different browser name in the xml. 
This xml also contain a listener at test suite level which generates a very nice test report with all the details
containing Passed, Failed and Skipped test cases.

ToDoTest class - This is main class where all the test cases for ToDo screen are created. This class uses ToDoPageEvents class to perform different events on the ToDo screen. 

BaseTest class - This class is created for setting up the webdriver and testng annotations. This class can be extended by
any other Test class to setup the webdriver for any browser and for exiting the browser.  

ElementFetch class - This class is created to find the web elements of the ToDo screen and it can be called from any other 
classes to find the any type of element(s) on the screen.

ToDoPageElements interface - This interface contains all the elements of ToDo screen.

ToDoPageEvents class - This class contains all the events that can be performed on ToDo Screen.

Constants interface - This interface contains all the constants values used to test ToDo screen.

ExtentIReporterSuiteClassListenerAdapter - This adapter of extentreports-testng-adapter jar is used in testng.xml 
to generate the Test Report.A extent property file is maintained to provide path for the report to this adapter. 
A sample report can be found in reports folder of the project root.
```

###How to run and package
```
prerequisite - java and maven should be installed locally.

run below command in command prompt from project root directory:

mvn clean install
```

##Test Scenarios Covered
###Positive Test Cases
```
Page title "todos" exist.
Page footer "Double-click to edit a todo" exist.
Add a ToDo and check if it is added.
Add a ToDo , select it using toggle and check if it selected and also to a check on number of items.
Add a ToDo, edit it and check if it edited.
Add multiple ToDos and check if they are added, Also do a check on "number of item".
Add multiple ToDos, select them all, check "number of items" left, clear them and check if All ToDos are removed.
Add multiple ToDos, select some of them, verify "number of items" and check if selected ToDos are completed.
Add a ToDo, delete it using delete icon and check if it deleted.
Add a ToDo, select it and then delete it using delete icon and check if it deleted.
Add multiple ToDos and delete some of them using delete icon, check not remaining ToDo still exist and check "number of items" left.
Add multiple ToDos, delete them all and check if all ToDos are deleted.
Add multiple ToDos, select one of them, delete it and check the remaining ToDos still exist.
```

###Negative Test Cases
```
"Number of item" text is not visible when there are no ToDos added.
"Clear completed" option is not visible when there are no ToDos added.
Add an ToDo and select it, check number of items, clear it, and verify "number of items"and "Clear completed" not visible.
Add multiple ToDos, don't select them and check if clear completed option not visible.
```