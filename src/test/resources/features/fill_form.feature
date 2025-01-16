Feature: Fill in form from https://demoqa.com/automation-practice-form

  Scenario: Fill form valid values
    Given I visit "https://demoqa.com/automation-practice-form"
    When I fill in student detials:
    |firstName|lastName|email|gender|mobile|date|subjects|hobbies|address|state|city|
    |Johnny|Depp|test@email.com|male|0123456789|09 Jun 1963|chemistry|reading|3 simba road|NCR|Delhi|
