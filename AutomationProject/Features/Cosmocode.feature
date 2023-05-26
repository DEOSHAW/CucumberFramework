Feature: Cosmocode
@cosmocode
Scenario: Highlight country on Web table
Given Cosmocode portal is open
When User searches for any of below countries
|India|Japan|Argentina|
|Australia|Brazil|Austria|
Then the searched country is highlighted