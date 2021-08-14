Feature: Free API
@freeAPI
Scenario: Search for any api
Given Free API portal is launched
When user looks up for "<SearchTerm>"
Then the search results will be shown