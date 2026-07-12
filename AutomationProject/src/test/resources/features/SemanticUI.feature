Feature: SemanticUI
@semanticui
Scenario: Input text
Given SemanticUI portal is open
When User types below in the input box
|Angular|
|React|
Then the input box is highlighted