Feature: Onliner search

  Background:
    Given User is on "https://www.onliner.by" page

#  Scenario Outline: Search for "iPhone 13 Pro" in the Onliner Catalog
#    And The browser is maximized
#    When User searches for "<phone>"
#    Then "<description>" is the first search result
#    Examples:
#      | phone                 | description                       |
#      | iPhone 13 Pro Max     | Смартфон Apple iPhone 13 Pro Max  |
#      | Xiaomi RedMi Note Pro | Смартфон Xiaomi RedMi Note 11 Pro |

  Scenario: Search for "iPhone 13 Pro" in the Onliner Catalog
    Given User is on "https://www.onliner.by" page
    And The browser is maximized
    When User searches for "iPhone 13 Pro Max"
    Then "Смартфон Apple iPhone 13 Pro Max" is the first search result
    And Search result contains the next characteristics
      | OS        | SCREEN                | CAMERA | SIM NUMBER |
      | Apple iOS | 6.7" OLED (1284x2778) | 12 Мп  | 1 SIM      |

