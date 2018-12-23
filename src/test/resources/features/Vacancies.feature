#Author: ninamishchenko31@gmail.com
@Vacancy
Feature: As an admin, I should have the ability to add Vacancies.

  Background: 
    Given I log in to HRM with credentials "Admin" and "admin123"
    Given I click Recruitment Module and click Vacancies

  Scenario: 
    And Click Add
    And Select  Job Title to any job Title "Finance Manager"
    And Enter  Vacancy Name "m"
    And Enter  Hiring Manager to "Thomas Fleming"
    And Enter  Number Of Positions "1"
    And Enter  Description "John is manager"
    And I Click Save
    Then I see vacancy details are displayed

  Scenario: 
    And I enter following values and click save
      | JobTitleManager | Finance Manager |
      | JobVacancy      | m            |
      | Manager         | Thomas Fleming  |
      | Status          | All             |
    Then I see Vacancy appears
    
  Scenario: 
    And I enter following values and click save
      | JobTitleManager | Finance Manager |
      | JobVacancy      | m          |
      | Manager         | Thomas Fleming  |
      | Status          | All             |
    And Validate Vacancy appears and click on check box and delete
