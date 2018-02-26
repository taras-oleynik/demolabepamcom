# new feature
# Tags: optional

Feature: Product search result page
  As a anonymous customer
  I want to be able to search product on site
  So that I can quickly search products and see search results

  Background:
    Given I am on home page
    And I search for "Angle Grinder"
    And I am redirected to a Search page

  Scenario: Search and view search result
    When I find 3 products with name "RT-AG"
    Then all products contain image, price, button "Add to cart"

  Scenario: Add to cart
    When click "Add to cart" button for product "RT-AG"
    Then add to cart confirmation pop-up appears

  #Scenario: Go to PDP
    #When click on product "RT-AG" on search result page
    #Then I am redirected on product details page