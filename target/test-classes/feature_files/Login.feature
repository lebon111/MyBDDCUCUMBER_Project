@TutorialsNinjaLogin
Feature: Login functionality of TutorialsNinja

Background: Trying to remove the repititive step present in all scenarios
Given User navigates to LoginPage
And User clicks on Login button

@ValidCredentials
Scenario: Login with valid credentials
When User enters valid email 'seleniumpanda@gmail.com'
And User enters valid password 'Selenium@123'
Then User is navigated to AccountPage

@InvalidCredentials
Scenario: Login with invalid credentials
When User enters invalid email 'seleniumpandahelloworld@gmail.com'
And User enters invalid password 'Selenium@123456'
Then User gets warning message about credentials mismatch

@ValidEmailInvalidPassword
Scenario: Login with valid email and invalid password
When User enters valid email 'seleniumpanda@gmail.com'
And User enters invalid password 'Selenium@123456'
Then User gets warning message about credentials mismatch

@InvalidEmailValidPassword
Scenario: Login with invalid email and valid password
When User enters invalid email 'seleniumpandahelloworld@gmail.com'
And User enters valid password 'Selenium@123'
Then User gets warning message about credentials mismatch

@NoCredentials
Scenario: Login without credential
Then User gets warning message about credentials mismatch

