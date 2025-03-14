Feature: BBL
@bbl
Scenario: Get BBL Standings
Given BBL portal is open
When User navigates to standings
Then standings is displayed on the BBL portal