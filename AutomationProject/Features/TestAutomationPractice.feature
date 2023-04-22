Feature: TestAutomationPractice
@testautomation
Scenario: Copy Text by double clicking
Given TestAutomationPractice portal is open
When User types below text in Field1
|Text|
|Text to be copied|
And User double clicks on the copy text button
Then the text is copied to Field2