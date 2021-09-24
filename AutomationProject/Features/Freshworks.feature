Feature: Freshworks feature
@freshworks
Scenario Outline: Search with a keyword
Given Freshworks portal is launched
And user searches for a "<SearchTerm>"
Then the serach result for "<SearchTerm>" is found

Examples:
|SearchTerm|
|Delight made easy|