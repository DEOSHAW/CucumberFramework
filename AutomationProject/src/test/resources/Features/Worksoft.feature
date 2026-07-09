Feature: Worksoft
@worksoft
Scenario: Spot the product
Given Worksoft portal is open
When User looks for below product
|Connective Automation Platform|
|Certify|
Then the product is highlighted