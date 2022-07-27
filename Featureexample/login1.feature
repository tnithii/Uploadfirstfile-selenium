
Feature: Login feature
Background:  URL and submit
Given when the usesr enters the URL

@Smoke
Scenario: Valid Login
  


When the user enters the valid username and password 
And the user clicks the submit button 
Then the user should be redirected to the profile page

@Regression  
Scenario: Invalid Login
  

When the user enters the invalid username and password 
And the user clicks the submit button 
Then it should show the error message
  
