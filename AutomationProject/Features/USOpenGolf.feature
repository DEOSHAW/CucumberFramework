Feature: US Open Golf
@usopen
Scenario: Search for Player
When USOpen portal is open
And User clicks on players menu
And User searches for below player
|PlayerName|
|Rory|
|Dustin|
Then the player is displayed