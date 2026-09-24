Feature: IIEST
@iiest
Scenario: Validate Menu Options
Given User is on IIEST portal
When User is on Homepage on IIEST portal
Then below menu options are displayed
|menu|
|Home|
|Academic|
|Admission|
|Research|
|Student|
|People|
|Innovation|
|Facilities|
|Placement|
|Notification|