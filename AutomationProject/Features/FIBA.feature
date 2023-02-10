Feature: FIBA
@fiba
Scenario: Search on FIBA portal
Given FIBA portal is open
When User searches for below on FIBA portal
|Champions|
Then the result is displayed on FIBA portal