@hackerrank
Feature: HackerRank

Scenario: Sign up on HackerRank
Given Hacker Rank sign up page is open
When user clicks on signup button
And user enters folowing details on the page
|Deo Shaw|deo.shaw@gmail.com|Test123|
|Deo Prasad|deo.prasad@gmail.com|Test124|
Then the signup is completed

Scenario: Sign up on HackerRank page
Given Hacker Rank sign up page is open
When user clicks on signup button
And user enters folowing details on the web page
|Name|Email|Password|
|Deo Shaw|deo.shaw@gmail.com|Test123|
|Deo Prasad|deo.prasad@gmail.com|Test124|
Then the signup is completed
