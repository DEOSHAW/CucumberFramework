Feature: UltimateQA
Background: Launch UltimateQA portal
Given User opens UltimateQA portal

@ultimateQaPricing
Scenario: Get UltimateQA Pricing
When User extracts the pricing
Then Pricing is displayed