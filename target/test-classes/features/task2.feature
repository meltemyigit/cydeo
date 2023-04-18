@Task2
Feature: Wikipedia Verification
  Agile story:

  TC#2: Wikipedia Search Functionality Title Verification
  1. User is on Wikipedia home page
  2. User types Steve Jobs in the wiki search box
  3. User clicks wiki search button
  4. User sees Steve Jobs is in the wiki title

  TC#3: Wikipedia Search Functionality Header Verification
  1. User is on Wikipedia home page
  2. User types Steve Jobs in the wiki search box
  3. User clicks wiki search button
  4. User sees Steve Jobs is in the main header

  TC#4: Wikipedia Search Functionality Image Header Verification
  1. User is on Wikipedia home page
  2. User types Steve Jobs in the wiki search box
  3. User clicks wiki search button
  4. User sees Steve Jobs is in the image header
  Note: Follow POM


  Scenario: Search Page Title Verification
    When User is on Wikipedia home page
    And  User types "Elon Musk" in the wiki search box and clicks wiki search button
    Then User sees "Elon Musk" is in the wiki title


  Scenario: Search Page Title Verification
    When User is on Wikipedia home page
    And  User types "Bill Gates" in the wiki search box and clicks wiki search button
    Then User sees "Bill Gates" is in the main header


  Scenario: Search Page Title Verification
    When User is on Wikipedia home page
    And  User types "Steve Jobs" in the wiki search box and clicks wiki search button
    Then User sees "Steve Jobs" is in the image header

  Scenario Outline: Search Page Title Verification
    When User is on Wikipedia home page
    And  User types "<searchValue>" in the wiki search box and clicks wiki search button
    Then User sees "<expectedTitle>" is in the image header
    Examples:search values we are going to be using in this scenario is as below
      | searchValue  | expectedTitle   |
      | Steve Jobs   | Steven Paul Jobs |
      | Bill Gates   | Bill Gates      |
      | Elon Musk    | Elon Musk       |
      | Kate Winslet | Kate Winslet    |


