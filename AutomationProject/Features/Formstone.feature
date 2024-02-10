Feature: Formstone
@formstone
Scenario: Upload file
Given Formstone portal is open
When User uploads below file
|fileName|
|Upload_a_file.png|
Then the file gets uploaded on Formstone portal