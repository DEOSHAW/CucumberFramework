Feature: ESPN CricInfo
@cricinfo
Scenario: Get the names of top 5 highest run getters in test
Given ESPN CricInfo site is launched
And the user find the top five run getters
Then the list of highest run getters is displayed