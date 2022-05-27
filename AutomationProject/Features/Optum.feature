Feature: Optum
@optum
Scenario Outline: Optum Information
Given Optum portal is open
When user searches on Optum for "<Term>"
Then the result is displayed on Optum portal
Examples:
|Term|
|Optum Pay|