Feature: IBSF
@ibsf
Scenario: Highlight social media handle
Given User is on IBSF portal
When user scrolls down to bottom on IBSF portal
Then below social media is highlighted
|Facebook|
|LinkedIn|