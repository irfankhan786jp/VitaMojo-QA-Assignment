Feature: Successful Login on VMOS Portal

Scenario: Successful Login via UI
  Given User navigates to VMOS application
  When User enters login details
  Then User is successfully logged in

  Scenario Outline: Successful Login via API
    Given User logins VMOS application with "<name>" and "<Email>"
    When User inputs credentials
    Then User gets successfully logged in

    Examples:
      | name | Email          |
#      | asad | asad@gmail.com |
      | Irfan | irfankhan786jp@gmail.com |