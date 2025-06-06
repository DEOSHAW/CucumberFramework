@seleniumbaseio
Feature: SeleniumBaseIo

Background: Open SeleniumBaseIO portal
Given User is on SeleniumBaseIO portal is open

@seleniumbaseioframes
Scenario: Get the Iframe Text
When User navigates to iframe text
Then iframe text is highlighted

@seleniumbaseiosvg
Scenario: Get SVG element colour
When User extracts the colour
Then Colour is displayed

@seleniumbaseioportal
Scenario: Navigate to SeleniumBaseIo portals
When User is navigated to corresponding portal
|seleniumbase.com|seleniumbase.io|

@seleniumbaseiotext
Scenario: Relative Locator demo
When User navigates paragraph text
Then the text is highlighted

@seleniumbaseiodocs
Scenario: Navigate to SeleniumBaseIo docs portal
When User clicks on docks link
Then user is navigated to below portal
|SeleniumBase Docs|

