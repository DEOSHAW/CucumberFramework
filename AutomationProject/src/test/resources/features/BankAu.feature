Feature: Bank AU
@aubank
Scenario: Search in AU Bank portal
Given user is on AU bank portal
When User searches for below on Au bank portal
|Keyword|
|Deposit|
|Interest|
Then correct result is displayed on AU bank portal