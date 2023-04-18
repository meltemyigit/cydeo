@FLEET10-1031
Feature: US-001 Login Function without any credential
  Agile Story : As a user, I should be able to log in

  Background:
    # create pre-condition on jira
    Given User is on the login page

    # create Tests for each scenarios on Jira, Summary=Scenario sentences
  # @tc-number is here

  @FLEET10-1026
  Scenario: Login as a Driver
    When The user logs in as a driver
    Then The user is on the Quick Launchpad page

@FLEET10-1028
  Scenario: Login as a sales manager
    When The user logs in as a sales manager
    Then The user is on the Dashboard page

@FLEET10-1030
  Scenario: Login as a store manager
    When The user logs in as a store manager
    Then The user is on the Dashboard page
#2-"Invalid username or password." should be displayed for invalid
# (valid username-invalid password and invalid username-valid password) credentials
  @FLEET10-1042
  Scenario: Login with invalid username and valid password
    When The user enter invalid username and valid password
    Then The user see Invalid user name or password error message
  @FLEET10-1045
  Scenario: Login with valid username and invalid password
    When The user enter valid username and invalid password
    Then The user see Invalid user name or password error message

  #3- "Please fill out this field" message should be displayed if the password or
  #username is empty(if both of them is empty, just username field should throw the warning message)
  @FLEET10-1047
  Scenario: Login with empty username and random password
    When The user enter empty username and random password
    Then The user see Lütfen bu alanı doldurun error message
  @FLEET10-1049
  Scenario: Login with random username and empty password
    When The user enter random username and empty password
    Then The user see Lütfen bu alanı doldurun error message
  @FLEET10-1051
  Scenario: Login with empty username and empty password
    When The user enter empty username and empty password
    Then The user see Lütfen bu alanı doldurun error message

  #4-User land on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
  @FLEET10-1053
  Scenario: Click Forgot your password? link
    When The user click Forgot your password? link
    Then The user see Forgot Password page

    #5-User can see "Remember Me" link exists and is clickable on the login page
  @FLEET10-1055
  Scenario: "Remember me on this computer" link exists
    Then The user see Forgot Remember me on this computer link
  @FLEET10-1057
  Scenario: Clickable "Remember me on this computer" link
    When The user see Remember me on this computer link is clickable

  #6-User should see the password in bullet signs by default (like ****)
  @FLEET10-1059
  Scenario: User should see the password in bullet signs by default (like ****)
    When User type the password
    Then User see the password in bullet signs by default

    #7- Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
  @FLEET10-1060
  Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page
    When User press enter key of the keyboard
    Then User see enter key is working

  #8- All users can see their own usernames in the profile menu, after successful login
  @FLEET10-1062
  Scenario: All users can see their own usernames in the profile menu, after successful login
    When User enter valid username and valid password and click
    Then User see own username in the profile menu
