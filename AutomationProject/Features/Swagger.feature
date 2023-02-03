Feature: Swagger
@swagger
Scenario: Get Open Source tools
Given Swagger portal is open
When user gets the list of open source tools
Then Open Source tools are displayed