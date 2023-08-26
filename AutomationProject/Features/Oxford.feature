Feature: Oxford
@oxford
Scenario: Get Quick Links
Given Oxford portal is open
When User navigates to quick link section
Then all the quick links are displayed