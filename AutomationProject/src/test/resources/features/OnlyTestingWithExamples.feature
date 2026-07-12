Feature: Only Testing with Examples

Background: Navigate to Tooltip section
Given Only Testing site is open
When User navigates to Tooltip examples section

@onlytestingexamples
Scenario Outline: Enter Details
And User enters details "<Name>","<Surname>" and "<Address>"
Examples:
|Name|Surname|Address|
|Devansh|Agarwal|Bangalore|
|Mala|Gupta|Mumbai|

