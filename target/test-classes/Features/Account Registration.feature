Feature: Successful User Registration on VMOS Portal

  @Registration
  Scenario: Create a User account via UI
    Given User navigates to VMOS application
    When User submits account details for creation
    Then User gets successfully created

  Scenario Outline: Create a User account via API
    Given User open VMOS application with "<name>" and "<Email>"
    When User sends account details for creation
    Then User gets successfully created via API

    Examples:
      | name | Email          |
      | asad | asad@gmail.com |
#      | Irfan | irfankhan786jp@gmail.com |