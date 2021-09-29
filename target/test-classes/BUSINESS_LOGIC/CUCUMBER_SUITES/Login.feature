Feature: Login feature

Background: user is successfully logged in
Given user opens "chrome" browser and exe "G:\\Automation Support\\chromedriver.exe"
Given user enters url "https://www.flipkart.com/"
Given user cancle the initial login window
Given user move on Login button


@SmokeTest
Scenario Outline: login functionality with valid username and valid password
When user click on my profile
When user enter <username> as  username
When user enter <password> as  password
When user click on Login button
Then validate Login page
Then close browser Window


Examples:
       |username|password|
       |9168313434|DDDD@1234|
     





























