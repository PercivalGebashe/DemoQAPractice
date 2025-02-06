Feature: Perforn different actions at https://demoqa.com/automation-practice-form

  @SmokeTest
  Scenario: Fill form valid values
    Given I visit "https://demoqa.com/automation-practice-form"
    When I fill in student details:
    |firstName|lastName|email|gender|mobile|date|subjects|hobbies|address|state|city|
    |Johnny|Depp|test@email.com|male|0123456789|February 14th, 2025|Chemistry,Maths|Reading|3 simba road|NCR|Delhi|
    Then I submit the form



    Scenario: Switch to new tab within window
      Given I visit "https://demoqa.com/browser-windows"
      When I click on the new tab button
      Then A new tab should open with url "https://demoqa.com/sample"


    Scenario: Switch to new window
      Given I visit "https://demoqa.com/browser-windows"
      When I click on the new window button
      Then A new window should open with url "https://demoqa.com/sample"

      Scenario: Switch to new window with message
        Given I visit "https://demoqa.com/browser-windows"
        When I click on the new window with message button
        Then A new window should open with url with massage "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization."


      Scenario: Switch to an iframe with id
        Given I visit "https://demoqa.com/frames"
        When I switch to iframe with Id "frame1"
        Then I should be in frame with heading "This is a sample page"