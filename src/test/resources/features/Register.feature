@register
Feature: Registration Functionality
@tag
Scenario: User creates an account with only mandatory fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName    |Shravan  |
|lastName     |v        |
|email        |vv.shravan18@gmail.com|
|telephone    |123456   |
|password     |Shravan123|
And User selects privacy policy
And User clicks on continue button
Then User account should get created successfully


Scenario: User creates an account with all fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName    |Shravan  |
|lastName     |v        |
|email        |vv.shravan1815@gmail.com|
|telephone    |123456   |
|password     |Shravan123|
And User selects Yes for Newsletter
And User selects privacy policy
And User clicks on continue button
Then User account should get created successfully

Scenario: User creates a duplicate account
Given User navigates to Register Account page
When User enters the details into below fields
|firstName    |Shravan  |
|lastName     |v        |
|email        |vv.shravan1814@gmail.com|
|telephone    |123456   |
|password     |Shravan123|
And User selects Yes for Newsletter
And User selects privacy policy
And User clicks on continue button
Then User should get a warning about duplicate email

Scenario: User creates an account without filling any fields
Given User navigates to Register Account page
When User dont enters the details into fields
And User clicks on continue button
Then User should get proper warning messages for every mandatory field

