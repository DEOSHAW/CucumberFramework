Feature: PluralSight

Background: Launch PluralSight
Given PluralSight portal is open

@pluralsight
Scenario: Get PluralSight objective
When User looks for pluralSight objective
Then the PluralSight objective is displayed

