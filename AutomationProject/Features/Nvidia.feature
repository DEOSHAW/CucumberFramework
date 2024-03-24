Feature: Nvidia
@nvidia
Scenario: Search on Nvidia portal
Given Nvidia portal is open
When User searches for below on Nvidia portal
|Term|
|GPU|
|CPU|
Then search result is displayed on Nvidia portal