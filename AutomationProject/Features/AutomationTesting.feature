@automationTesting
Feature: Automation Testing

Background: Prerequisites Steps
Given User navigates to Automation Testing portal

@automationtestingMenu
Scenario: Validate Menu Options
When User is on homepage of Automation Testing portal
Then menu has below links
|ACCORDIAN|BROWSER TABS|


@automationtestingAccordion
Scenario Outline: Validate Accordion
When User navigates to accordion page on Automation Testing portal 
Then below accordion title is present "<accordionTitle>"

Examples: 
|accordionTitle|
|Platform Portability|
|Language Support|
|Selenium Grid|
