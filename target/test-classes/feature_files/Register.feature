@TutorialsNinjaRegister
Feature: Register functionality of TutorialsNinja

Background: Trying to remove the repititive step present in all scenarios
Given User navigates to RegisterPage
And User clicks on Continue button

  @MandatoryFields
  Scenario: Register with mandatory fields
    When User enters below mandatory fields
    |firstname 			| Selenium 			|
    |lastname				| Panda 				|
    |telephone			| 9876543210 		|
    |password				| Selenium@123 	|
    |confirmpassword| Selenium@123 	|
    And User selects PrivacyPolicy checkbox
    Then User account gets created successfully


 @AllFields
  Scenario: Register with all fields
    When User enters below all fields
    |firstname 			| Selenium 			|
    |lastname				| Panda 				|
    |telephone			| 9876543210 		|
    |password				| Selenium@123 	|
    |confirmpassword| Selenium@123 	|
    And User selects Yes for newsletter
    And User selects PrivacyPolicy checkbox
    Then User account gets created successfully
    
 
 
  @DuplicateEmail
  Scenario: Register with existing email
    When User enters below all fields with existing email
    |firstname 			| Selenium 							|
    |lastname				| Panda 								|
    |email 					|seleniumpanda@gmail.com|
    |telephone			| 9876543210 						|
    |password				| Selenium@123 					|
    |confirmpassword| Selenium@123 					|
    And User selects Yes for newsletter
    And User selects PrivacyPolicy checkbox
    Then User gets warning message of duplicate email  
 
 
  @NoFields
  Scenario: Register with no fields
    Then User gets warning message for mandatory fields
    