Feature: MLR
@mlr
Scenario Outline: Search for MLR teams
Given MLR portal is open
When User searches for the "<Team>" on MLR site
Then the team is displayed on the MLR site

@chicago
Examples:
|Team|
|CHICAGO HOUNDS|

@miami
Examples:
|Team|
|MIAMI SHARKS|
