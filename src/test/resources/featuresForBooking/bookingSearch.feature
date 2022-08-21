Feature: Booking search

  Background:
    Given User is on "https://www.booking.com/searchresults.en-gb.html" page

  Scenario Outline: Search for "Hotel" in the SearchBox
    And The browser is maximized
    When User searches for "<hotel>" and "<city>"
    Then "<hotel>" exists on the Search page
    Examples:
      | hotel            | city  |
      | Rixos            | Dubai |
      | Hilton           | Dubai |
      | Marriott         | Dubai |
      | Hyatt            | Dubai |
      | The Ritz-Carlton | Dubai |
      | Four Seasons     | Dubai |
      | Radisson         | Dubai |

  Scenario Outline: Search for "Rating" in the SearchBox
    And The browser is maximized
    When User searches for "<hotel>" and "<city>"
    Then Search result contains the "<rating>" equals to
    Examples:
      | hotel            | city  | rating |
      | Rixos            | Dubai | 9.1    |
      | Hilton           | Dubai | 7.9    |
      | Marriott         | Dubai | 8.6    |
      | Hyatt            | Dubai | 8.8    |
      | The Ritz-Carlton | Dubai | 8.8    |
      | Four Seasons     | Dubai | 9.0    |
      | Radisson         | Dubai | 8.2    |


