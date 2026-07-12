Feature: UPES
@upes
Scenario: Search on UPES portal
Given UPES portal is open
When User searches for below on the UPES portal
|searchFirst|searchSecond|
|Scholarship|Placements|
Then search result is displayed