@automationdemo
Feature: Automation Demo

Background: Navigate to Home Page
Given Automation Demo site is open
When User clicks on Skip Sign In link

@automationframes
Scenario: Frames switching Demo
When User navigates to frames switching page
And user switches to frame
And User types in the inputbox
And User switches back to parent frame
Then label of parent frame is displayed

@automationaccordion
Scenario: Accordion Demo
When User navigates to Accordion page
When User clicks on an accordion
Then accordion text is displayed

