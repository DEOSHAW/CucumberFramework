Feature: SailGP
@sailgp
Scenario: Search For Teams
Given SailGP portal is open
When User searches for the SailGP team
|Team|
|Australia|
Then the team details are displayed