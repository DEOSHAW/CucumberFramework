Feature: JMeter
@JMeter
Scenario: Find Keywords on JMeter portal
Given JMeter portal is open
When User looks up for below keywords on Jmeter portal
|Database via JDBC|
|FTP|
|SOAP / REST Webservices|
Then the keyword is found