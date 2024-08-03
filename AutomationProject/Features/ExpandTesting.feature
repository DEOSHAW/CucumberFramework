@expandtesting
Feature: Expand Testing

Background: Launch Expand Testing portal
Given Expand Testing portal is open

Scenario: Print Task Manager Table
When User navigates to Dynamic table page
Then Table values are printed in the console for Chrome

