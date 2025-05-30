@expandtesting
Feature: Expand Testing

Background: Launch Expand Testing portal
Given Expand Testing portal is open

@expandTestingPrintTable
Scenario: Print Task Manager Table
When User navigates to Dynamic table page
Then Table values are printed in the console for Chrome

@expandTestingPageTitle
Scenario: Validate Page title
When User extracts page title from ExpandTesting site
Then page title should be below
|pageTitle|
|Practice Web UI & API Test Automation WebSite|

@expandTestingPage
Scenario: Get Page Title
When User gets the page title
Then page title is as expected


