Feature: LTIMindtree

@ltimindtree
Scenario: Search on LTIMindtree portal
Given LTIMindtree portal is open
When User searches for below on the LTIMindtree portal
|Employees||Revenue|
Then the search result is displayed on LTIMindtree portal