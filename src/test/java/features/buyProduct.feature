Feature: Open Product Detail and Place the order for product

  Scenario Outline: Buy Product Experience in My Demo App

    Given user is on ecommerce landing page
    When  user open product detail page for "<product>" item
    Then  user select colour "<colour>" for the item
    And   user increase quantity until "<quantity>" pieces

    Given user add product to the cart
    When  user is on cart page
    Then  validate product name in cart page matches with "<product>"
#    And   validate product colour in cart page mathes with "<colour>" -> not able to found any locator that contains Blue text
    And   validate product quantity in cart page matcher with "<quantity>"

    Given user is on login page
    When  user login using username "Automation Testing" and password "Password123"
    Then  user is able to login

    Given user is on enter shipping address page
    When  user fill the shipping address detail
    Then  user proceed to payment page

    Given user is on enter payment method page
    When  user fill the payment method detail
    Then  user proceed to review order page

    Given user is on review order page
    When  user is validating order data "<product>" "<colour>" "<qtyReview>"
    Then  user proceed to place order
    And   user complete checkout

    Examples:
    | product              | colour | quantity | qtyReview |
    | Sauce Lab Back Packs | Blue   | 2        | 2 Items   |
