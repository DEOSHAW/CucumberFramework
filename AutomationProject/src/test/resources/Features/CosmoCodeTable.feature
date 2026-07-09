Feature: CosmoCode Table
@cosmocodetable
Scenario: Select Country checkbox
Given CosmoCode table page is open
When User finds below country
|India|
|Australia|
Then the checkbox is selected on Cosmocode table