Feature: ViaBenefits
@viabenefits
Scenario: Search for Plan on the portal
Given ViaBenefits portal is open
When User searches for below plan
|Retiree|
Then the plan is displayed