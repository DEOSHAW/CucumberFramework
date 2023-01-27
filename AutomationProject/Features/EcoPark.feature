Feature: EcoPark
@ecopark
Scenario: Search for Activity
Given EcoPark portal is open
When User searches for below activity
|Activity|
|Zorbing|
|Archery|
Then the activities are displayed