Feature: Heroku

@herokuFileUpload
Scenario: Upload a file
Given Heroku portal is open
When  User navigates to file upload page
And   User uploads a file
Then  the file gets uploaded

@herokuDynamicContent
Scenario: Get Dynamically Loaded Content
Given Heroku dynamic content portal is open
When  User clicks on Second link
And   User clicks on start button
Then  the dynamic content is displayed

@herokuframe
Scenario: Switch to middle frame
Given Heroku frame page is open
When user switches to middle frame
Then middle text is highlighted

@herokuloginalert
Scenario: Handle Login Alert
When User user logs in with basic auth to heroku portal
Then welcome message is displayed

@herokuredirection
Scenario: Validate Redirect Scenario
Given User is on Heroku redirection portal
When User clicks on redirection link
Then new page is rendered