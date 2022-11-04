@AllUsers
Feature: Library app login feature

  User Story:
  As a user, I should be able to login with correct credentials to different accounts


 # Background: Assuming user is on the login page


  @librarian
  Scenario: Login as librarian
    Given I am on the login page
    When  I login as librarian
    Then  Dashboard should be displayed

  @student
  Scenario: Login as student
    Given I am on the login page
    When  I login as a student
    Then  books should be displayed