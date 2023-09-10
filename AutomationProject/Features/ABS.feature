Feature: ABS
@abs
Scenario Outline: Search for B School
Given ABS portal is open
When User searches for "<Keyword>" on ABS portal
Then Search result is displayed on ABS

Examples:
|Keyword|
|B-School|