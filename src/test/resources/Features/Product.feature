Feature: This feature verify product search functionality

  Scenario: Verify when user searches for Levis the all results search
    Given Enter Levis in search component
    When User click on search magnifier
    Then All results populated must contain word Levis in it.
