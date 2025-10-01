Feature: Coursera
@coursera
Scenario: Search for courses
Given Coursera portal is open
When User searches for below on Coursera
|Testing|Data Science|
Then the search result is displayed on Coursera