Feature: Heroku
@herokuFileUpload
Scenario: Upload a file
Given Heroku portal is open
When User navigates to file upload page
And User uploads a file
Then the file gets uploaded