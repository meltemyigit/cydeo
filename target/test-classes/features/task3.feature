@Task3
Feature: Login scenario Verification
  Agile story:
  1- Given user is already logged in to web table app
  2- When user is on the “Order” page
  3- Then user enters appropriate test data
  a. Product
  b. Quantity
  c. Customer name
  d. Street
  e. City
  f. State
  g. Zip
  h. Payment info:
  i. Card type: Visa/MasterCard/American Express
  ii. Card No
  iii. Expire date
  4- And user clicks to “Process Order”
  5- Then user should see new order in the table on “View all orders”
  page
  Note: Follow POM
#1- Parameterize scenario
#2- Scenario Outline after.
  Background:
    When User is on the login page of Web table app
    





