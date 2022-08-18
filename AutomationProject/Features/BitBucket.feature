Feature: BitBucket
@bitbucket
Scenario: Search for product
Given Bitbucket portal is open
When user searches on Bitbucket for below
|Term1|Term2|
|BitBucket|Jira|
Then the serach result on Bitbucket is displayed