Feature: Docker feature
@docker
Scenario Outline: Search for Keyword
Given Docker portal is launched
When user seraches for keyword "<Key>"
Then the top result is displayed

Examples:
|Key|
|Testing|