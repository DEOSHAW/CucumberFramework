Feature: Qspider
@qspider
Scenario: Validate modal
Given QSpider portal is open
When user navigates to modal 
And user clicks on open modal button
Then modal pop up is displayed
