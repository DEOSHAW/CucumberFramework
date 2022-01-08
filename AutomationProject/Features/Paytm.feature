Feature: Paytm
@paytm
Scenario Outline: Search for Keyword
Given Paytm portal is launched
When user searches for <Keyword> on paytm
Then the result is displayed on paytm

Examples:
|Keyword|
|"India"|
