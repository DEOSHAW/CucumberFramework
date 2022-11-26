Feature: Cypress
@cypress
Scenario: Get Cypress Pricing
Given Cypress portal is open
And User navigates to Pricing section
And User searches for pricing for below
|LicenseType|
|Free|
|Enterprise|
|Business|
Then the pricing for the searched license is displayed