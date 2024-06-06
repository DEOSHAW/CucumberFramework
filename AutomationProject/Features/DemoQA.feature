Feature: DemoQA
@demoQADragAndDrop
Scenario Outline: Drag And Drop In Box
Given DemoQA portal is launched
When user drags and drops the element "<DraggableElement>"
Then Successful message for dropping is displayed

Examples:
|DraggableElement|
|Acceptable|
|Not  Acceptable|