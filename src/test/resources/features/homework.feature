@HomeWork
Feature: As a user
Scenario: homework

Given Wait for the webtable to be visible
When Assert that headers size is 6.
When Assert headers are “Name, Position,Office,Extn., Start Date, Salary
When Find Bruno Nash in the table then verify that he is a Software Engineer and works in London
When Print all webtable content in a similar looking format
When Click on NEW button
When Add new Employee information
When Search for the employee
When Verify All data displayed in the webtable matched the data you entered in step 8.