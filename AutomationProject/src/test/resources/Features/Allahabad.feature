Feature: University of Allahabad
@uoa
Scenario: Highlight the Menu Option
When User is on UOA portal
And User hovers over below link
|linkName|
|Academics|
|About|
|Student|
Then the link is highligted on the UOA portal
