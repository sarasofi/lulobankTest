#Author: marycala11@gmail.com
Feature: API Testing
  I want as a tester to make a get request
  getting as a response an specific employee
  of the api and validate the response

  Scenario: Get an employee
    Given I want make a request on dummy API
    When I make a resquest to get an employee with id "1" 
    Then I validate the body and the status code 200
