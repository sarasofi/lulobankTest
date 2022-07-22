#Author: marycala11@gmail.com
Feature: API Testing
  I want as a tester to make a post request
  Creating a new employee on the
  Api and validate the response

  Scenario: Post- Create an employee
    Given I want make a request on dummy API
    When I make a post request to create a employee
      | name   | test |
      | salary |  123 |
      | age    |   23 |
    Then I validate the response of the post request and the status code 200
