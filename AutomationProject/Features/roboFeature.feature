@roboFeature
Feature: Robot Framework Libraries
Scenario: Search Libraries 
Given Robo portal is launched
When open Libraries link in a new tab
And Validate the Libraries text on page
Then robo Site is closed