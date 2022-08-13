Feature: Chromium portal

Background: Chromium portal launch
Given Chromium portal is launched

@chrome
Scenario: Find the latest chrome driver version
When User looks up for the latest driver version
Then the driver version is displayed
