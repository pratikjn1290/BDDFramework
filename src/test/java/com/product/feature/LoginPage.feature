Feature: Login Page Feature

Scenario: Login page title
Given user is on login page
When user gets title of the page
Then page title should display "Login - My Store"

Scenario: Forgot Password link
Given user is on login page
Then forgot password link should display

Scenario: Login with valid username and password
Given user is on login page
When user enters username "pratikj048@gmail.com"
And user enteres password "Test@12345"
And user click on login button
Then user gets title of the page
And page title should display "My account - My Store"