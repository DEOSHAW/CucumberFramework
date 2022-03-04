Feature: Multi Select List
Background: Open Portal
Given MultiSelect portal is open

@cars
Scenario: Get all the elements from the multi select list
Given user gets the list of all the options from the car List
Then the list of cars is displayed