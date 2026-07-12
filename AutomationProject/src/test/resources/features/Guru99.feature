@guru99
Feature: Guru99 Tests
Background: Open Guru99 Demo site
Given Guru99 portal is open

@guru99tooltip
Scenario: Tooltip Test
When User navigates to tooltip page
And User hovers over tooltip of Download link
Then Content of tooltip is displayed
