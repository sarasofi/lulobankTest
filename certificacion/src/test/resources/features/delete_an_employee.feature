#Author: marycala11@gmail.com
Feature: API Testing
  I want as a tester to make a delete request
  getting as a response a suceesful message
  of the api and validate the response

  Scenario: Delete an employee
    Given I want make a request on dummy API
    When I make a resquest to delete an employee with id "2" 
    Then I validate the body and the status code 200
