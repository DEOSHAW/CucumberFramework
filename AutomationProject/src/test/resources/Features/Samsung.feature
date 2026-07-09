Feature: Samsung
@samsung
Scenario Outline: Search for Samsung Product
Given Samsung portal is launched
When User Clicks on Search button
And User Searches for "<Product>" on Samsung portal
Then Refrigerators are dispalyed on Samsung portal
Examples:
|Product|
|Refrigerators|