Feature: AFL
@afl
Scenario: Get AFL Team Rankings
Given AFL portal is open
When user navigates to Teams' rankings page
Then the rankings is displayed