Feature: NewFront
@newfront
Scenario: Get Menu Labels
Given NewFront portal is open
When User is on homepage of NewFront portal
Then the menu items are highlighted