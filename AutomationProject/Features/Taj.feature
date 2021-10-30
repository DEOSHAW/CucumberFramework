Feature: Taj Mahal
@Taj
Scenario Outline: Get Visit Timing
Given Taj mahal official site is launched
And user clicks on VisitingHours link
And user seraches for timing "<timingKeyword>"
Then the visiting time is displayed
Examples:
|timingKeyword|
|30 Minutes|
