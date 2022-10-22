Feature: Text Input

@uitp_text
Scenario: Validate difference between DOM event and Keyboard operation
Given UITP_Text_Input portal is open
When User pastes the text in textbox
Then button name should not change
When User types the text in textbox
Then button name should get updated