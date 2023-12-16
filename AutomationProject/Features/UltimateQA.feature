Feature: UltimateQA
Background: Launch UltimateQA portal
Given User opens UltimateQA portal

@ultimateQaPricing
Scenario: Get UltimateQA Pricing
When User extracts the pricing
Then Pricing is displayed

@ultimateQaDropdownTest
Scenario: Validate Selected value in the dropdown
When User lands on the dropdown page
And User Selects a value from the dropdown
Then Selected value is displayed