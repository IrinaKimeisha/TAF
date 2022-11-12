Feature: Более сложный тест для изучения Cucumber

  Rule: работаем со стандартным пользователем

    Background:
      Given открыт браузер

    Scenario: Использование AND
      When страница логина открыта
      Then отображается поле username

    Scenario: Использование AND 2
      When страница логина открыта
      Then отображается поле username

  Rule: работаем со стандартным пользователем 1

    Background:
      Given открыт браузер

    Scenario: Использование AND
      When страница логина открыта
      Then отображается поле username

    Scenario: Использование AND 2
      When страница логина открыта
      Then отображается поле username

