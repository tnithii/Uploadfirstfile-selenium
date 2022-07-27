
Feature: Login feature
Background:  URL and submit
Given when the usesr enters the URL

@Smoke
Scenario: Valid Login
  


When the user enters the credentials "Admin" and "admin123" 
And the user clicks the submit button 
Then the user should be redirected to the profile page

@Regression  
Scenario Outline: Invalid Login
  

When the user enters the invalid "<username>" and "<password>" 
And the user clicks the submit button 
Then it should show the error message
Examples: 
|username|password| 
|Admin12|admin1234|
|a123|ad12|
|adm|adm123|
  