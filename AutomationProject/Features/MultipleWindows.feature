Feature: Multiple Windows

@multiwindow
Scenario: Test multiple window feature in Selenium4
Given Portal1 is launched
And User performs operations in first window
And user opens a new tab
And performs operation in the second window
And user switches back to first window
