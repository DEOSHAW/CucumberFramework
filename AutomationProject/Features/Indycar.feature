Feature: IndyCar
@indycar @indy
Scenario: Search on Indy Series portal
Given Indy Series portal is open
When User searches for below on Indy Series portal
|Term1|Term2|
|Indy|Schedule|
Then search result is displayed on Indy Series portal