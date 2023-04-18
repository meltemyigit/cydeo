@deneme
Feature: Example of Cucumber data table implementations

  Scenario: List of fruits I like
    Then user should see fruits I like
      | Kiwi        |
      | banana      |
      | cucumber    |
      | orange      |
      | mango       |
      | grape       |
      | pomegranate |
    #to beautify the pipes above
    #windows:control + alt + l