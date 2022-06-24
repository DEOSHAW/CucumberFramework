Feature: FIFA
@fifa
Scenario: Find rankings of specific countries
Given FIFA portal is launched
When user searches for the rankings of below countries
|Germany|
|France|
Then the ranking is displayed