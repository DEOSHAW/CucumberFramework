@nextGen
Feature: NextGenAI
Background: Open Portal
Given NextGenAI portal is open

@alertNextGenAI
Scenario: Alert Boxes
When User navigates to alerts page
And User clicks on buttons to generate portals and handles them
Then the texts on the popup is captured

@alertNextGenWebTable
Scenario: Web Table
When User navigates to Web table page
Then the web table values are printed