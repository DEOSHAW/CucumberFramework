Feature: WebDriver University
@webdriveruniversity
Scenario: Search for a Course
Given User is on WebDriver University portal
When user searches for below course on the university portal
|Selenium WebDriver 4|
|Cypress with Cucumber BDD|
|Selenium + Cucumber + Java|
|Complete WebdriverIO Course|
Then the course is displayed on the university portal