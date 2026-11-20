Feature: WorldoMeter
@worldometer
Scenario: Get live population of India
Given Worldometer portal is open
When User Extracts India Population
Then Population is displayed