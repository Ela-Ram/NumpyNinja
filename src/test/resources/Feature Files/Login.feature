@Login
Feature: Login Functionality

  Background: The user navigates to the Sign-in page
  @signinpg
  Scenario: Navigate to the LOGIN Page
    Given The user is on the DS Algo Home Page
    When The user clicks the Getstarted tab
    Then The user should be redirected to the Sign-in page
    
     @emptyfields
  Scenario: Display error for empty username and password
    Given The user is on the DS Algo Sign-in Page
    When The user clicks LOGIN button with no inputs
    Then The error message Please fill out this field. appears below the Username textbox

  @emptypassword
  Scenario: Display error for empty password field
    Given The user is on the DS Algo Sign-in Page
    When The user enters validUsername and leaves the password empty
    Then The error message Please fill out this field. appears below the Password textbox

  @emptyusername
  Scenario: Display error for empty username field
    Given The user is on the DS Algo Sign-in Page
    When The user enters validPassword and leaves the username empty
    Then The error message Please fill out this field. appears below the Username textbox

  @invalidcredentials
  Scenario: Display error for invalid credentials
    Given The user is on the DS Algo Sign-in Page
    When The user enters invalidUsername and invalidPassword
    Then The error message Invalid Username and Password. should be displayed

  @validcredentials
  Scenario: Successful login with valid credentials
    Given The user is on the DS Algo Sign-in Page
    When The user enters validUsername and validPassword
    Then The user should navigate to the Data Structure Home Page with the message You are logged in
    
 