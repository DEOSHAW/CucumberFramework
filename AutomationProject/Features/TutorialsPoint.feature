Feature: Tutorials Point

Background: Open site
Given Tutorials point slider site is open

@tp
Scenario: Select value through slider
When user selects "80"
Then the value is selected
