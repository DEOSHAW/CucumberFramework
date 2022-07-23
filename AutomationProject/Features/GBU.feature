Feature: GBU
@gbu
Scenario: Search on GBU portal
Given GBU portal is open
When user searches for below on GBU portal
|Term|
|Rankings|
And user clicks on one of the search links
Then the result text is displayed