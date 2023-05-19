Feature: MLS
@mls
Scenario: Search for the new Team
Given MLS portal is open
When User searches for the new team
Then Search result for the new team is displayed