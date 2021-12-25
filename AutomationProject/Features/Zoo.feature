Feature: Zoo
@zoo
Scenario: Get the list of Birds
Given Zoo portal is launched
When user clicks on Birds
Then the list of birds is displayed