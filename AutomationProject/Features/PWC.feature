@pwc
Feature: PWC
Scenario Outline: Search for jobs in PWC
Given PWC portal is launched
When user searches for "<searchTerm>" keyword
Then total number of job opportunities are displayed

Examples:
|searchTerm|
|Careers|