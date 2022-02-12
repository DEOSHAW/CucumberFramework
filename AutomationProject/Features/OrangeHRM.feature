Feature: Orange HRM
@hrm
Scenario Outline: Explore Free Trial
Given OrangeHRM portal is launched
When user types email id <Email>
And user clicks on submit
Then registration page is displayed

Examples:
|Email|
|"deo.it@gmail.com"|
