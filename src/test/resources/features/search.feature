Feature: The user search a product on the Tesco webshop

  Rule: Search funktion

    Background:
      Given open main page
      And accept cookies

      @Tc_SearchWithResult
    Scenario Outline: Search with result

      When search a "<product>" wich exist
      Then it shows the result



      Examples:
        | product |
        | cukor   |
        | kenyér  |


    @Tc_SearchWithoutResult
    Scenario Outline: Search withouth result
      Given search bar is on the page
      When search a "<product>" wich does not exist
      Then it do not shows the result


      Examples:
        | product |
        | cuk111   |
        | kenyércukor  |