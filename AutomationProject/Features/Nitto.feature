Feature: Nitto
@nitto
Scenario: Locate the country specific website
Given User is on Nitto portal
When User looks for below on Nitto portal
|Country|
|India|
|Japan|
|China|
Then the country is located on the web page
