Feature: Elevenia - Add to Cart

  Background:
    Given I open browser
    And I open elevania homepage

  Scenario: I want to add and delete item in cart
    When I search "komputer"
    And I choose first product in Produk terlaris tab
    And I added to cart
    And I click Ubah Kurir button
    And I click Batal in pop up confirmation
    And I removed an item from cart
    Then Cart is empty
