Feature: Science City
@scity
Scenario: Write information in a file
Given Science city portal is launched
When user navigates to info section
And user extracts the information
Then the informaton is written in a text file