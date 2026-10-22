Feature: EBC
@ebc
Scenario: Validate Customer Satisfaction
Given EBC portal is open
When User navigates to customer satisfaction section
Then customer satisfaction statistics are shown