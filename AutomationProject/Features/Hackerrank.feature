@hackerrank
Feature: HackerRank
Background: Prerequisites Steps
Given Hacker Rank sign up page is open
When user clicks on signup button

Scenario: Sign up on HackerRank
When user enters following details on the page
|Deo Shaw|deo.shaw@gmail.com|Test123|
|Deo Prasad|deo.prasad@gmail.com|Test124|
Then the signup is completed

Scenario: Sign up on HackerRank page
When user enters following details on the web page
|Name|Email|Password|
|Deo Shaw|deo.shaw@gmail.com|Test123|
|Deo Prasad|deo.prasad@gmail.com|Test124|
Then the signup is completed
