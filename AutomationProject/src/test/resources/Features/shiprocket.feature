Feature: Shiprocket
@shiprocket
Scenario Outline: Search on Shiprocket portal
Given Shiprocket portal is open
When User searches for below term
|Term1|Term2|
|Shipping|businesses|
Then search result on Shiprocket portal is displayed