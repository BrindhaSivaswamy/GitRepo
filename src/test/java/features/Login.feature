Feature: Application Login 

Scenario Outline: Home page login
Given Intialize the driver with chrome
And Navigate to "http://qaclickacademy.com/index.php" site
And Click on login link to land on secure sign in page
When user enters <username> and <password>
Then Verify user is succesfully logged on
And close browsers

Examples:
|username			|password|
|test99@gmail.com		|123456|
|test787@gmail.com		|15654|	
