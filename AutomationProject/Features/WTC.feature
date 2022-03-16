Feature: WTC
@wtc
Scenario: Get WTC Rules
Given WTC portal is launched
When user searches for the rules
Then the rules are displayed