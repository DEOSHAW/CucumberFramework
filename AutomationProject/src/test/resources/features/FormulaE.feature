Feature: Formula E
@formulae
Scenario: Highlight Menu
Given Formula-E portal is open
When User provides below menu to highlight
|Menu|
|Calendar|
|Results|
Then menu is highlighted on Formula-E portal