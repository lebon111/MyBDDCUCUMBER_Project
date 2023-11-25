@TutorialsNinjaSearchProduct
Feature: Search Product functionality of TutorialsNinja

Background: Trying to remove the repititive step present in all scenarios
Given User opens the application
And User clicks on the search button

@ValidProduct
Scenario: Search with valid Product
When User enters the valid product 'HP'
Then User gets valid product info display in SearchPage


@InvalidProduct
Scenario: Search with invalid Product
When User enters the invalid product 'DELL'
Then User gets warning message


@NoProduct
Scenario: Search with no Product
Then User gets warning message