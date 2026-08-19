Feature: ETPL
@etpl
Scenario: Search for player
Given User is on ETPL portal
When User navigates to Players page
And User searches for player
Then Player is found