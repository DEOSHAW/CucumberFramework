Feature: Whirlpool
@whirlpool
Scenario: Search for Whirlpool Products
Given Whirlpool portal is open
When User searches for below products on Whirlpool site
|KitchenProducts|LivingRoomProducts|
|Washing Machines|Air Conditioners|
|MicroWave|Cooler|
Then the search result is displayed on the Whirlpool portal