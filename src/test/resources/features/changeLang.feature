Feature: The user shall be able to change the language in Tesco.hu

  Rule: Allow to change the language

    Background:
      Given open main page
      And accept cookies

      And language is set to "<magyar>"
      When change the language to "<english>"
      Then it shows elements in "<english>"










