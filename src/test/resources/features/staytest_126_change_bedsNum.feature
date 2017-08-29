 @Steytest_126
Feature: As a user,When guest is looking at the search results,
 the search results should update if the user changes the number of beds
 
Scenario: search for spesific bed numbers 
	Given I am on the fourstay homepage 
	And I enter school name "Georgetown university" 
	And I enter dates "03/01/2018" and "03/02/2018" 
	And I click the search button 
	