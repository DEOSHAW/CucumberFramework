Feature: Upenn
@upenn
Scenario: Validate home page Image
Given User is on Upenn portal
And User takes the screenshot on homepage
Then Image is captured