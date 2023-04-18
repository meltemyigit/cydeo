@FLEET10-1078
Feature: US-002 Log out Function
  Agile Story : As a user, I should be able to log out

  Background:
    # create pre-condition on jira
    Given User type valid username and valid password and click login button

    # create Tests for each scenarios on Jira, Summary=Scenario sentences
    # @tc-number is here
  @FLEET10-1072
    #1- The user can log out by using the log out button inside profile info and the User should land on the "Login" page after logging out.
  Scenario: User Logout by using log out button
    When The user click log out button
    Then The user see login page

  @FLEET10-1075
  #2- The user can not go to the home page again by clicking the step back button after successfully logging out.
  Scenario: User can not go to the home page again by clicking the step back button after successfully logging out
    When The user click log out button
    And The user click back button
    Then The user see login page

  @FLEET10-1077
  #3- The user must be logged out if the user closes the open tab (all tabs if there are multiple open tabs)
  Scenario: User must be logged out if the user closes the open tab
    When The user close the all tab
    And The user go to the login page
    Then The user see login page

  @FLEET10-1080
    #4- The user must be logged out if the user is away from the keyboard for 3 minutes (AFK)
    #(if the user does not do any  mouse or keyboard action for 3 minutes)
  Scenario: User must be logged out if the user is away from the keyboard for three minutes
    When The user wait three minutes without doing anything
    Then The user see login page
