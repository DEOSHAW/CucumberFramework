Feature: LPU
@lpu
Scenario Outline: Find the course
Given LPU portal is open
When user Searches for "<course>"
Then the course is highlighted

Examples:
|course|
|BUSINESS|
|EDUCATION|