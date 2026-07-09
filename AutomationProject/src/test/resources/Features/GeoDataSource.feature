Feature: GeoDataSource
@geodatasource
Scenario: Search on GeoDataSource Portal
Given GeoDataSource portal is open
When user searches for below on GeoDataSource portal
|Customization|Country|
Then the search result on GeoDataSource portal is displayed