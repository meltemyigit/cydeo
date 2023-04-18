@Task1
Feature: Google searh functionality
  Agile story:
  1. User is on Google search page
  2. User types apple in the google search box and clicks enter
  3. User sees Steve Jobs is in the google title
  Note: Follow POM

  Scenario: Search page title verification
    When User is on Google search page
    And  User types apple in the google search box and clicks enter
    Then User sees Steve Jobs is in the google title

