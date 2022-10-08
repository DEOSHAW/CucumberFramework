Feature: Overlapping Element
@overlapped
Scenario: Enter text in Overlapping TextBox
Given UITest Overlapping Element page is open
When user unhides the overlapping text box and enters below values in overlapping text Box
|ID|Name|
|1|Deo|
|2|Dev|
|3|Deb|
Then the text should be entered in the overlapped text box
