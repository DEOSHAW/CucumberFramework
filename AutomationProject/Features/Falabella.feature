Feature: Falabella
@falabella
Scenario: Get geographical presence
Given Falabella site is open
When user gets the list of countries
And user selects below country
|Country|
|Chile|
Then the list of countries is displayed