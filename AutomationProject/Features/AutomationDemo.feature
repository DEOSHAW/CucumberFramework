Feature: Automation Demo

Background: Navigae to Home Page
Given Automation Demo site is open
When User clicks on Skip Sign In link

@automationframes
Scenario: When User navigates to frames switching page
And user switches to frame
And User types in the inputbox
And User switches back to parent frame
Then label of parent frame is displayed
