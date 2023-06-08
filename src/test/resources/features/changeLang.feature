Feature: The user shall be able to change the language in BudapestGo

  Rule: Allow to change the language

    Background:
      Given open main page
      And accept cookies

    Scenario Outline: Change language
      Given language is set to "<language>"
      When change the language to "<new_language>"
      Then it shows elements in "<new_language>"

      Examples:
        | language | new_language |
        | magyar   | angol        |
        | angol    | magyar       |









