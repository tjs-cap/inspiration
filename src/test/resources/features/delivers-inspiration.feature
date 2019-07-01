Feature: Delivers Inspiration
  As a user who lacks motivation
  I want an inspirational quote tempered by reality delivered
  So that I can be more thoughtful during the rest of my day

  Scenario: The home page contains a quote placeholder
    Given I select the home page
    When I view the content
    Then An HTTP 200 OK is received
    And The page contains "not feeling it, yet"