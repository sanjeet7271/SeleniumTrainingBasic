# NAGP Assignment 

## Features supported
1. Dependency management and project management by Local(within Project itself -> latest one)
2. TestNG for testing work flow
3. TestNG reports
4. Logging via Log4j
5. Property Reader to read Test data from properties files.
6. Custom assertion to print custom message when assertion fails.
7. Used dataProvider to create multiple user, post and comments, reading test data from excel sheet
8. All offline jar and drivers are placed into project itself.
9. There are 4 test cases and All test cases are independent to each other.

## Pre-requisite
1. Java version above 1.8.
2. Maven version above 3.0.
3. TestNG 6.14.3
4. Apache POI 3.17

## How to install & Run using command prompt
1. Please extract the project at your desired path.
2. Go to `config/configuration.properties` file and update user name in configurations.
	for e.g.	if you want to run test cases for "Chrome", then just update name into browser field
				like : BROWSER=chrome
3. Go to `/assertTestData/testData.xlsx` and insert test product name and no of product to verify actual and expected from excel sheet 	
4. Open the command prompt and go to the project path.
5. Set class path using cmd command : set classpath={project location}\bin;{project location}\jars\* and press enter

	where {project location}= project location where you kept extracted project from zip file
	for e.g for : D:\NAGP\Sanjeet_3149591
	
6. Now Run Command : java org.testng.TestNG {project location}\testng.xml	and press Enter
	
	where {project location}= project location where you kept extracted project from zip file
	for e.g for : D:\NAGP\Sanjeet_3149591

7. All the automated test cases in the testNG.xml will be executed.

8. or can be executed by write click on testng.xml or write click on TestCases.java class




Note : Bug 1: There is Bug when We search through the entire product name. I is searching only specific name.
	For example: 
	when we iterating through product list and printing 1st product then 
	full product name is printing : Faded Short Sleeve T-shirts $16.51
	and we searching this text from search box, no product is searching until specifying exact product name
	
	Bug 2: Site title changing frequently.. so assertion sometimes failed.