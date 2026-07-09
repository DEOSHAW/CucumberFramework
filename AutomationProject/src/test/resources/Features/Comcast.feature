Feature: Comcast
@comcast
Scenario: Get Environment Pledge
Given Comcast portal is open
When User navigates to Environment page
Then Environment pledge is displayed