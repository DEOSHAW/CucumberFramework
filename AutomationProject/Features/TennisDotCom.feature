Feature: TennisDotCom
@tennisdotcom
Scenario Outline: Login with incorrect credentials
Given User is on tennisdotcom portal
When User clicks on user icon link
And User logs in with "<username>" and "<password>"
Then error message "WRONG EMAIL OR PASSWORD." is displayed
Examples:
|username|password|
|user1@gmail.com|pwd1|
|user2@gmail.com|pwd2|