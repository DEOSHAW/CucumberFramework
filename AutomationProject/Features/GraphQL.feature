Feature:GraphQL
@graphql
Scenario Outline: Search Information
Given GraphQL Portal is launched
When the user seraches for a "<searchTerm>"
Then the result is displayed

Examples:
|searchTerm|
|GraphQL|
|graphql|