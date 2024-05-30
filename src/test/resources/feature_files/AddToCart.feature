@TutorialsNinjaAddToCart
Feature: AddToCart functionality of TutorialsNinja
  

@ValidateAddingTheProductToCartFromHomePage
Scenario: Verify Product Added To ShoppingCart SuccessFully
    Given User is on the Homepage
    When User click on Iphone link
    And User enters quantity using the Select class
    And User clicks on the Add To Cart button
    Then the message should be displayed
    
@ValidateAddingTheProductToCartFromSearchResultsPage
Scenario: Verify that User Places an Order Successfully
    Given User is on the Homepage
    When User search for product  
    And User clicks on search button
    And Select product 
    And Verify the Text 
    And Select Delivery Date
    And User clicks on the Add To Cart button
    And Verify the Message Success
    
@ValidateAddingTheProductToCartFromDisplayedCategoryDropdownMenu   
Scenario: Verify Product is Added to Shopping Cart Successfully
    Given User is on the Homepage
    When User clicks on Phones & PDAs link 
    And User click on Iphone link
    And User enters quantity using the Select class
    And User clicks on the Add To Cart button
    Then the message should be displayed
    