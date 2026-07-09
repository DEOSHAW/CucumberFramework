Feature: Super Rugby
@superrugby
Scenario: Search for Team
Given Super Rugby website is open
When User Searches for below
|Team|
|Crusaders|
|Chiefs|
Then the team is displayed