Feature: Coforge
@coforge
Scenario Outline: Search for a term
Given Coforge portal is launched
When User searches for the "<Term>"
Then the search result on Coforge site is displayed

Examples:
|Term|
|Enduring Relationships|
