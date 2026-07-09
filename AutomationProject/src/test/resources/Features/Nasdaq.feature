Feature: Nasdaq
@nasdaq
Scenario: Search on Nasdaq portal
Given Nasdqa portal is open
When User searches for below on Nasdaq portal
|Markets|
|Investors|
Then result is displayed on Nasdaq portal