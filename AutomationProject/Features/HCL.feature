Feature: HCL
@hcl
Scenario: Get Trending News
Given HCL portal is launched
When user Extracts the news
Then the news is displayed