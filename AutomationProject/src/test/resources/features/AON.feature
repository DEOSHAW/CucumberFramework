Feature: AON
@aon
Scenario: Navigate to Insights Page
Given AON portal is open
When User navigates to insights page 
Then the title of the page on AON is "Insights | Aon"