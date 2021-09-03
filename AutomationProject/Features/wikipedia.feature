Feature: Wikipedia
@wiki
Scenario: Get different search categories
Given Wikipedia portal is open
When user extracts the categories
Then the categories are displayed