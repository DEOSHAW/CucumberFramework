@seleniumbase
Feature: Selenium Base Demo
@seleniumbase_checkbox_demo
Scenario: Check the Boxes
Given Selenium Base portal is open
When User checks the checkboxes
Then boxes should get checked

@seleniumbase_svg
Scenario: Interact with SVG Element
Given Selenium Base portal is open
When User clicks on SVG Element
Then SVG Element is highlighted