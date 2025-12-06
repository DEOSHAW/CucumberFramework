Feature: World Aquatics
@worldaquatics
Scenario: Search on World Aquatics Portal
Given World Aquatics portal is open
When User searches for below on world aquatics portal
|Keyword|
|Latest|
|High|
Then the search result is displayed on the portal