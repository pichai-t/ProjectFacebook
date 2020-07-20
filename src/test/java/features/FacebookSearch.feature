Feature: Facebook Searching

  Scenario: facebook search
    Given a web browser is at the facebook home page
    When the user enters keyword into the search bar
    Then links related to keyword are shown on the results page