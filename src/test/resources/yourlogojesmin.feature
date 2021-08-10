@smokeTest@jenkinsTest
Feature: verify checkout feature from your logo website

Scenario: user able to successfully login to your logo website
  Given user go to your logo homepage
 And click on the Sign in button
 When user enter valid Email address and password
And user click on the Sign in button
Then user nevigate to home page 
 And verify the page title as "My account - My Store"
 Then user click on the upper left corner Dresses
And print price value in desendeing sorted order
And user select the second dress from the list
Then user click on Add to cart
 And user verify Total price with shipping is there
Then user sign out
And user close the browser