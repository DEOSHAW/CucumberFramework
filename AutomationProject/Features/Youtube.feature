Feature: Youtube
@youtube
Scenario Outline: Serach for Videos
Given Youtube Portal is launched
When user searches for "<videoTitle>"
Then the search results are displayed

Examples:
|videoTitle|
|Selenium Tutorial|