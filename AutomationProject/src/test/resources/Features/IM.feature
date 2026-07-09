Feature: IM
@IM
Scenario Outline: Log in to Individual Marketplace with incorrect credentials
Given User is on IM portal
When User clicks on Sign In link
And User logs in with "<username>" and "<password>" on IM portal
Then error message is displayed
Examples:
|username|password|
|user1@test.com|password1|
|user3@test.com|password3|
