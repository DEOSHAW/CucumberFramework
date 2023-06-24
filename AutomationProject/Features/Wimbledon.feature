Feature: Wimbledon
@wimbledon
Scenario: Get the Entry List
Given Wimbledon portal is open
When User clicks on Entry list link
Then the entry list is displayed