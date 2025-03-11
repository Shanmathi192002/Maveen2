@WishlistTest
Feature: Wishlist

  Background:
    Given I am logged in to Demoblaze

  Scenario: User adds product to wishlist
    When I add the product "Samsung galaxy s6" to the wishlist
    Then I should see the product in the wishlist
