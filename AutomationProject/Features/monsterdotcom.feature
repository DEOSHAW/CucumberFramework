Feature: Monster Dot Com
Background: Launch Job site
Given Monster India site is open

@job
Scenario: Get Employers Of Choice
When user extracts the employers of choice
Then the list is displayed

