Feature: Mercury Tour
@mercurytour
Scenario: Find Flights
Given Mercury tour portal is open
When User navigates to flights page
And User searches for flights on Mercury tour portal
Then the search result for flights is displayed