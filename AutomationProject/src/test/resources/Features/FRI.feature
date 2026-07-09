Feature: FRI
@fri
Scenario: Validate Email ID of FRI
Given FRI portal is open
When User stores the email
Then email is validated successfully