Feature: ViaBenefits
@viabenefits
Scenario: Navigate to login Page of spending accounts
Given Via Benefits portal is open
When User navigates to login page of Via Benefits
Then Login page of Via Benefits is loaded with below message
|Welcome to Via Benefits|Sign into your Account|
