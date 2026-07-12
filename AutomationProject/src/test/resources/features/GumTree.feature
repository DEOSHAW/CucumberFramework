Feature: GumTree
@gumtree
Scenario: Search for Products
Given GumTree portal is open
When User searches for below items on GumTree
|ItemName|
|Books|
|Furniture|
Then the serach results are displayed on the GumTree portal