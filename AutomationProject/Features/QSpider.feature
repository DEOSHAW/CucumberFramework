Feature: Qspider
Background: Open QSpider Portal
Given QSpider portal is open

@qspidermodal
Scenario: Validate modal
When user navigates to modal 
And user clicks on open modal button
Then modal pop up is displayed

@qspiderwindow
Scenario: Navigate to new login window
When User navigates to new login window
And User switches to the new login window
Then User is on new login window
