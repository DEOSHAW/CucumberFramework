Feature: Practice Automation
@practiceautomation
Scenario: Login
Given User is on Practice Automation portal
When User logs in with below
|userName|password|
|student|Password123|
Then login is successful on practice automation portal