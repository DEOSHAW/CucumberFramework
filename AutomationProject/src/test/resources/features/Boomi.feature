Feature: Boomi
@boomi
Scenario: Search for Applications
Given Boomi portal is open
When User seraches for below on Boomi portal
|NetSuite|Oracle|
|Slack|SAP|
Then Search results is displayed on Boomi Portal