@Gmail @email
Feature: Gmail Feature

Background: Email website is open 
Given Gmail URL is Launched

Scenario: Log into Gmail with correct Credentials
When User Logs in with user "deoshaw3@gmail.com" and password "Devanshi@21"
Then User name "Deo" should be visible

Scenario: Log into Gmail with incorrect Credentials
When User Logs in with user "deoshaw4@gmail.com" and password "Devanshi@22"
Then Error message should be displayed

