@login
Feature: Login Functionality

Scenario: Login with valid credentials
Given User has navigated to login page
When User has entered valid email address "vv.shravan1814@gmail.com" into email field
And User has entered valid password "Shravan123" into password field
And User clicks on login button
Then User should get successfully logged in

Scenario: Login with invalid credentials
Given User has navigated to login page
When User has entered invalid email address "shravan1814@gmail.com" into email field
And User has entered invalid password "123456" into password field
And User clicks on login button
Then User should get a warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User has navigated to login page
When User has entered valid email address "vv.shravan1814@gmail.com" into email field
And User has entered invalid password "123456" into password field
And User clicks on login button
Then User should get a warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User has navigated to login page
When User has entered invalid email address "shravan1814@gmail.com" into email field
And User has entered valid password "Shravan123" into password field
And User clicks on login button
Then User should get a warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User has navigated to login page
When User dont enter email into email field
And User dont enter password into email field
And User clicks on login button
Then User should get a warning message about credentials mismatch