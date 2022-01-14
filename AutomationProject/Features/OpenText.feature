Feature: Open Text
@opentext
Scenario: Find Managed Services Overview
Given Open text portal is launched
When user clicks on managed services
And user switches to managed services window
Then the overview is displayed