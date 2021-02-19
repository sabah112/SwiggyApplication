@tag
Feature: Check number is registered or not
	This scenerio defines all the possible outcomes when a valid number is entered

@tag1
  Scenario: Registered mobile number
    Given valid registered mobile number
    And state of number (registered/not registered)
    And I am on the login page
    When I enter mobile number 
    And click for log in
    Then I validate the number
    And display otp textbox
    
@tag2
  Scenario: Registered mobile number
    Given valid not registered mobile number
    And state of number (registered/not registered)
    And I am on the login page
    When I enter mobile number 
    And click for log in
    Then I validate the number
    And display sign up page for registration of number
