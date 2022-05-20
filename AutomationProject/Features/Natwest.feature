Feature: Natwest
@natwest
Scenario: Get Career Information
Given Natwest portal is launched
When user clicks on Career
And user extracts the career information
Then Career information is displayed