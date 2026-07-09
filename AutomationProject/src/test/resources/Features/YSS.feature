Feature: YSS
@yss
Scenario: Search on YSS portal
When User is on YSS portal
And User finds with below term on YSS portal
|Book|
|Meditation|
Then search results are displayed on YSS portal