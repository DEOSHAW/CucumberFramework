Feature: ABS
@abs
Scenario: Search for B School
Given ABS portal is open
When User searches for below on ABS portal
|B-School|
Then Search result is displayed on ABS