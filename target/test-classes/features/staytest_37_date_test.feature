 @Steytest_37 
Feature: As a user I should be able to search stay for the a specified date range 
So that the result lists only stays that are available of those days
 
Scenario: search for spesific date and verify that it is not 
	Given I am on the fourstay homepage 
	And I enter school name "Georgetown university" 
	And I enter dates "03/01/2018" and "03/02/2018" 
	And I enter beds "2"
	And I click the search button 
	Then the results should contain "03/01/2018" 
	
		