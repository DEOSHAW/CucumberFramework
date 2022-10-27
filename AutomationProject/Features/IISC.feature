Feature: IISC
@iisc
Scenario: Get Department Names
Given IISC portal is open
When user navigates to department page
Then list of departments is displayed