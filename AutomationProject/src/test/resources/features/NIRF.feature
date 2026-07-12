Feature: NIRF
@nirf
Scenario: Validate NIRF about page
Given User is on NIRF portal
When User navigates to NIRF about page
Then overview information is found on NIRF about page