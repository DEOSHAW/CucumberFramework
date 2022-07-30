Feature: Oracle Apex Login
@oapex
Scenario: Oracle Apex Unsuccessful Login Scenario
Given Oracle Apex Application is open
When user logs in with below details
|Deo Shaw|drtty|ggjhj|
|Dev Shaw|drttg|ggjyj|
Then the login should be unsuccessful