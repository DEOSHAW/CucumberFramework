@amazonFeature
Feature: Amazon Guest Checkin

Scenario: Check Local currency Feature
Given Amazon portal is launched
When Navigate to local currency page
Then Validate The presence of Indian Currency

Scenario: Searching Product
Given Amazon portal is launched
When User Searches for the product "Watches"
And Search Result is Displayed
