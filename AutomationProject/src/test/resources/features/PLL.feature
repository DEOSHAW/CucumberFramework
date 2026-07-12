Feature: PLL
@pll
Scenario: Search for the team
Given PLL portal is open
When user searches for below on PLL portal
|Team|Conference|
|New York Atlas|EASTERN|
|Boston Cannons|WESTERN|
Then the search result is displayed on PLL portal