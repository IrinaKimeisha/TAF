Feature: Параметризированные тесты

  Scenario: простая параметризация
    Given открыт браузер
    And страница логина открыта
    When user "atrostyanko+aqa21@gmail.com" with password "Qwertyu#1" logged in
    Then Dashboard page is displayed
    * project with ID = 23 is displayed

  Scenario Outline: Таблицы
    Given открыт браузер
    And страница логина открыта
    When user "<username>" with password "<password>" logged in
    Then Dashboard page is displayed
    * project with ID = <projectID> is displayed

    Examples:
      | username                    | password  | projectID |
      | atrostyanko+aqa21@gmail.com | Qwertyu#1 | 23        |
      | atrostyanko+aqa21@gmail.com | Qwertyu#1 | 23        |

  Scenario: Doc Strings
    Given a description with text
    """
    some text ....
    """