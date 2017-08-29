@Steytest_36 
Feature: As a guest I should be able to see prices on the stay
So that stay meets my price requirements
and I can decide which property I should rent based on price shown on result page
 
Scenario: Verify results in DC metro area 

	Given I am on the fourstay homepage 
	When I login as a guest
	  
	And I enter school name "Georgetown university" 
	And I enter dates "07/29/2017" and "09/22/2017" 
	And I click the search button 
    Then the results should contain 

