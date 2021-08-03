Feature: SAP Labs
@sap
Scenario Outline: Find Products
Given SAPLabs portal is launched
When user searches for products with "<searchTerm>"
Then the top search results is displayed

Examples:
|searchTerm|
|Products|

