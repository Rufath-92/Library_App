Feature:Library app login feature (Login with parameters)


  @librarianParameters
  Scenario:Login as librarian 50
    Given I am on the login page
    When  I enter username "librarian50@library"
    *     I enter password "LXHU2DkJ"
    *     Click the sign in button
    Then  dashboard should be displayed
    *     There should be "1311" users


