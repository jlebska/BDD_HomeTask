Feature: Filtering and searching on Amazon

  Scenario: Brand Name filtering
    Given User is on "Category Page" for "Toys" category

    When User chooses a brand name "Star Wars" on "Category Page"

    Then All the titles of items contain the brand name "Star Wars" on "Category Page"

  Scenario: Price range filtering
    Given User is on "Category Page" for "Toys" category

    When User picks a price range "Under $25" on "Category Page"

    Then All prices are under "25.00" on "Category Page"

  Scenario: Sorting by price
    Given User is on "Category Page" for "Toys" category

    When User picks a price range "Under $25" on "Category Page"
    And User picks sorting by price high to low on "Category Page"

    Then The prices of visible items are sorted in a correct way on "Category Page"