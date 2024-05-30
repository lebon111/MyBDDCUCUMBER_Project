@TutorialsNinjaLogOut
Feature: Logout functionality
  

Scenario: Successful logout from Account page
  Given I am logged in to the Tutorialsninja demo website
  When I click on the Logout link
  Then I should see a message indicating that I have been logged out successfully
  
Scenario: Successful logout from My Account DropDown

  Given I am logged in to the Tutorialsninja demo website
  When I click on the Logout link from the My Account dropdown
  Then I should see a message indicating that I have been logged out successfully


  