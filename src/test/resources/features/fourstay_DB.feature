@DataBaseTest
Feature: Fourstay Data Base Testing

Scenario Outline: Verify AccountHolders info from General Account Settings 

	Given the user in on fourstay home page 
	When the useer clicks on the login link 
	And I enter email "<email> " 
	And I enter password "<password>" 
	When I click on the login button 
	Then I click on Edit Profile
	And I get firstname
	And I get lastname
	And I get email
	And I get phonenumber
	
	
	
	
	Examples: 
	| email                 | password |
| sking@testmail.com    | password |
| dlorentz@testmail.com | password |
| daustin@testmail.com  | password |
| isciarra@testmail.com | password |	
| imikkili@testmail.com | password |
| jnayer@testmail.com	| password |
| shiggins@testmail.com | password |
| acabrio@testmail.com  | password |
| rperkins@testmail.com | password |
| doconnel@testmail.com | password |
	