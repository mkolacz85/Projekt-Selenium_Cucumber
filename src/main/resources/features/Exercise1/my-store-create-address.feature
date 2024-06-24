Feature:Create User new Address
  As a logged-in user,
  I should be able to create my new address
  so that I can place orders and get deliveries.

  Scenario Outline: User create new Address
    Given the user is on the my store login page
    When the user types correct "<email>" and "<password>"
    And the user click sign button
    And the user click  address button at account page
    And the user click create address button at addresses page
    And the user fills  "<alias>", "<address>", "<city>", "<postalCode>", "<country>", "<phone>"
    And the user click save button
    Then the new address should be added
    Examples:
      | email              |password || alias   || address|| city| postalCode || country|phone |
      | mary1234@gmail.com |password || address || Happy|| London| 10-100|| United Kingdom| 123456|


