#Author: marycala11@gmail.com
Feature: API Testing
  I want as a tester to make a get request
  getting as a response all the employees
  of the api and validate the response

  Scenario: Get employees
    Given I want make a request on dummy API
    When I make a get request 
    Then I validate the body and the status code 200
