Feature: Yahoo
@yahoo
Scenario: Search for Keyword
Given Yahoo Portal is launched
When User seraches for below Keywords
|Selenium|Tutorial|
Then the results are displayed