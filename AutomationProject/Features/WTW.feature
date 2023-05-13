Feature: WTW
@wtw
Scenario: Search for Keyword
Given WTW portal is open
When User Searches for below keyword on WTW portal
|Risk|Insurance|
|Service|Technology|
Then the search result is displayed on WTW portal