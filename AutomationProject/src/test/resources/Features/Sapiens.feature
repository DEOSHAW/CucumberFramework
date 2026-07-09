Feature: Sapiens
@sapiens
Scenario: Search on Sapiens Portal
Given Sapiens portal is open
When User searches for below
|Careers|
Then Search result is displayed on the Sapiens portal