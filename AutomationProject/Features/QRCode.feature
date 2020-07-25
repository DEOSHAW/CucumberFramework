@QRFeature
Feature: QR Scan
Scenario: Sans QR Code and print details
Given QR Portal is launched
When Scans QR Code
Then Prints QR Code Details
