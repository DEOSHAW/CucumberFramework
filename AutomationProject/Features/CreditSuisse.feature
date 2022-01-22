Feature: Credit Suisse
@creditsuisse
Scenario Outline: Get Trending Info
Given Credit suisse portal is launched
When user searches for "<Keyword>" on CreditSuisse Portal
Then result is displayed

Examples:
|Keyword|
|Read more|