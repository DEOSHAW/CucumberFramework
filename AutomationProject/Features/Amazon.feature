@amazonFeature
Feature: Amazon Guest Checkin
Background:
Given Amazon portal is launched

@amazon1
Scenario: Check Local currency Feature
When Navigate to local currency page
Then Validate The presence of Indian Currency
@amazon2
Scenario: Searching Product
When User Searches for the product "Watches"
And Search Result is Displayed
