Feature: A Search functionality on the users page


  @Table_Header
Scenario: Table columns names
Given   I am on the login page
And     I login as librarian
And     I click on "Users" link
Then    Table should have following column names:
| Actions   |
| User ID   |
| Full Name |
| Email     |
| Group     |
| Status    |