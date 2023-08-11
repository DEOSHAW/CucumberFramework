Feature: HYR Tutorial
@hyr
Scenario Outline: Fill User Details
Given HYR tutorial portal is open
When User fills in "<firstName>","<lastName>" and "<Email>"
Then registration is completed
Examples:
|firstName|lastName|Email|
|Test|Automation|testautomation12@gmail.com|
