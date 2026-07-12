Feature: Coventry University
@coventry
Scenario: Navigate to Research Page
Given Coventry university portal is open
When User navigates to Research page
Then URL contains below term
|research|
