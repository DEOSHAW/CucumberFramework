Feature: TopCoder
@topcoder
Scenario: List top 50 competitive Programmers
Given TopCoder portal is launched
When User navigates to programmer rankings
Then the top fifty programmers are displayed 