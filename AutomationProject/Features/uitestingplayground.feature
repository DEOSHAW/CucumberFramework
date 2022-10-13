@uitestplayground
Feature: UI Testing Playground

@uitest_nbsp
Scenario: Non Breaking Space in Element
Given UI Testing Playground NBSP portal is open
When User clicks on nbsp element
Then the button gets clicked


@uitest_dt
Scenario: Dynamic table
Given UI Testing Playground DT portal is open
When User extracts the warning message for cpu message
Then cpu usage is displayed