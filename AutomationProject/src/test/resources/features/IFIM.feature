Feature: IFIM
@ifim
Scenario: Download Placement Report
Given IFIM portal is open
When User searches for below on IFIM portal
|Placement|Placement Report|
Then Placement Result is displayed