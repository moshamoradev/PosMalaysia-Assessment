Feature: Pos Malaysia Rate Calculator

  Scenario: Calculate shipping rates from Malaysia to Singapore
    Given I am on the Pos Malaysia rate calculator page
    When I select "Malaysia" as the origin country and "India" as the destination country
    And I input "35600" as origin country postcode
    And I input "1" as the parcel weight
    And I click Calculate button
    Then I should see multiple calculated quote rates
