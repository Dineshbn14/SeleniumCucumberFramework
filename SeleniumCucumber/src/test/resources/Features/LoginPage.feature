@LoginPage
Feature: Login Page feature

@LoginSwagLabs
Scenario Outline: Login Page Title
Given user is able to navigate to url
When user logs in as "<userId>" and "PasswordManger"  
Then user navigates to the dashboard and verifies title

 Examples:
    | userId |
    |standard_user|
#		|locked_out_user|
#	  |problem_user|
#		|performance_glitch_user|
#		|error_user|
#		|visual_user| 