Feature: US-001 Login Function without any credential

  Background:
    # create pre-condition on jira
    Given User is on the login page


    # create Tests for each scenarios on Jira, Summary=Scenario sentences
  # @tc-number is here
  Scenario: Login as a Driver
    When The user logs in as a driver
    Then The user is on the Quick Launchpad page


  Scenario: Login as a sales manager
    When The user logs in as a sales manager
    Then The user is on the Dashboard page


  Scenario: Login as a store manager
    When The user logs in as a store manager
    Then The user is on the Dashboard page

