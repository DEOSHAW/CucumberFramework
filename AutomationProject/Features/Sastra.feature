Feature: SASTRA
@sastra
Scenario Outline: Navigate to school portal
Given Sastra university portal is open
When user is on schools page
And User clicks on "<schoolName>" on sastra home page
Then User is switched to the school webpage
Examples:
|schoolName|
|School of Civil Engineering|
|School of Management|

