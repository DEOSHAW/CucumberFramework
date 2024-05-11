Feature: Deloitte
@deloitte
Scenario: Search on Deloitte portal
Given Deloitte portal is open
When User searches for below on Deloitte portal
|Career|
Then Search result is displayed on Deloitte portal