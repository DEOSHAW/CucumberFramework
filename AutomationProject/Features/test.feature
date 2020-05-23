@testFeature
Feature: Login Feature
  Verify if the user is able to Login to the Naukri site

  Scenario Outline: Login as an authenticated user
    Given user is  on homepage
    When user navigates to Login Page
    And user enters "<username>" and "<password>" Credentials
   Then success message is displayed
   Then close the Browser
   
 Examples:   
    | username   | password |
    | deoshaw3@gmail.com | Devanshi@21 |
    