Feature: Desktop Checkout for Guest User
  As a customer
  I want to be able proceed to checkout
  So that I can specify my delivery and payment details and place the order


  Scenario: Proceed to checkout, final review and place order as guest user
    Given I select "Add to cart" for product "693923"
    And I select "Check Out" in cart pop-up
    And I am redirected to the cart page
    And I can view order summary
      | Order Subtotal | Order Total |
      | $39.00         | $39.00      |
    And I click "Check out" button after redirect to cart page
    And I set "gi.sun@rustic-hw.com" as e-mail address
    And I set "Hybris123!" as a password

    And I have the following final review
      | Subtotal | Total  |
      | $39.00   | $39.00 |
    And I submit payment information and press "Next" button on PAYMENT TYPE page
    #   | Country       | Title | First Name | Last Name | Address Line 1  | City      | Region       | Post Code  |
     # a | United States | Mr.   | John       | Doe       | 16 Sandy Palace | Honesdale | Pennsylvania | 18431-0000 |
    When I press "Next" button on SHIPPING METHOD page
  #  And I am redirected to multicheckout delivery method page
   And I have the following on FINAL REVIEW page
      | Subtotal | Delivery | Total  |
      | $39.00   | $9.99    | $48.99 |
   # And I select "STANDARD DELIVERY - 3-5 BUSINESS DAYS - $9.99" delivery method
   # And I press "Next" button on delivery method page
  #  And I am redirected to multicheckout payment method page
  #  And I have the following final review
   #   | Subtotal | Delivery | Tax   | Total   |
   #   | $99.85   | $9.99    | $5.49 | $115.33 |
   # And I select to use my delivery address
   # And I agree with terms and conditions
   # And I press "Next" button on payment method page
   # And I am redirected to WorldPay page
  #  And I enter test card data
   #   | number         | 4111111111111111 |
   #   | year           | 2019             |
    #  | month          | 03               |
   #   | verificationID | 123              |
  #  And I click Make payment button
   # Then I am redirected to checkout confirmation page
  #  And I have the following final review at order confirmation page
   #   | Subtotal | Delivery | Total   | Tax   |
   #   | $99.85   | $9.99    | $115.33 | $5.49 |
  #  And checkout message is "Thank you for your Order!"
  #  And I can obtain an order number
  #  And I press "Continue shopping" button on checkout confirmation page
  #  And I am redirected to the home page
  #  And mini cart icon on home page shows 0 items in cart
