Feature: PKL
@pkl
Scenario: Search for the organizer
Given PKL portal is open
When User seraches for below
|managed by|
Then the organizer's name is displayed