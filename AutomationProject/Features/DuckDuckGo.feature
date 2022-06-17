Feature: DuckDuckGo
@duck
Scenario Outline: Search for Course
Given DuckDuckGo is open
When user searches for <Key> on the DuckDuckGo site
Then the results are displayed on DuckDuckGo
Examples:
|Key|
|"Cucumber Tutorial"|
