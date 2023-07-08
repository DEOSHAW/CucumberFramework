Feature: Cyient
@cyient
Scenario: Get Capabilities
Given Cyient portal is open
When User navigates to capabilities section
Then capabilities are displayed