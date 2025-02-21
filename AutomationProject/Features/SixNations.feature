Feature: Six Nations
@sixnations
Scenario Outline: Navigate to Six nations series
Given User is on six nations portal
When User clicks on "<seriesLink>"
Then User is redirected to the "<seriespage>"

Examples: 
|seriesLink|seriespage|
|Unders Six Nations|sixnationsrugby.com/en/u6n|
|Autumn Nations Series|sixnationsrugby.com/en/autumn-nations-series| 