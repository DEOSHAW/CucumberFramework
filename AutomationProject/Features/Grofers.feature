Feature: Grofers feature

Background: Launch Grofers
Given Grofers portal is launched

@grofers
Scenario Outline: Search for Vegetables
When user searche for vegetables with <Key>
Then the serach results are displayed

Examples:
|Key|
|"Vegetables"|
|"Fruits"|