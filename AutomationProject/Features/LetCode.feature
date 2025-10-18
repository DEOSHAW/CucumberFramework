Feature: LetCode
@letcode
Scenario: Select Action Heroes
Given User is on LetCode portal
When User selects below multiple options from dropdown on LetCode
|actionHeroes|
|aq|
|ca|
Then the selections are made on LetCode