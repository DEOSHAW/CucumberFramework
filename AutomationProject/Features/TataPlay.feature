Feature: Tata Play
@tataplay
Scenario: Highlight the particular link
Given Tata Play portal is open
When User selects below link
|Link|
|Go to My Account|
|I want a new DTH Connection|
Then the selected link is highlighted on Tataplay portal