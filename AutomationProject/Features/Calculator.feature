Feature: Calculator
@calc
Scenario: Add two numbers
Given Calculator portal is open
When user enters below two numbers 
|number1|number2|
|3|5|
|4|8|
Then the result of addition is displayed