Feature: Publicis Sapient
@publicis
Scenario Outline: Search on Publicis Sapient Portal
Given Publicis Sapient portal is launched
When User Searches for "<Term1>" and "<Term2>" on Publicis Sapient portal
Then the Search result on Publicis Sapient portal is displayed

Examples:
|Term1|Term2|
|Public|Sector|
