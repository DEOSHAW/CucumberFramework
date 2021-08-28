Feature: Udemy

Background: Udemy pre-requisites
Given Udemy portal is launched

@udemy
Scenario Outline: Get Courses
When user types "<courseName>"
Then the search result is displayed

Examples:
|courseName|
|Cucumber|
|Selenium|
