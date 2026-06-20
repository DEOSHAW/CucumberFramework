Feature: University of Bristol
@bristoluniv
Scenario: Search for Course
Given University of Bristol portal is open
When User searches for below course on Bristol portal
|AI|Electronics|
Then user is navigated to course result page