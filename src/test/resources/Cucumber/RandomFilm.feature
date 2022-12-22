#Feature: Get random unwatched film
#
#  Scenario Outline:
#    Given An <custid> has an unwatched film
#    When I request a random film
#    Then The webpage should show a film that has not been watched
#    Examples:
#      | custid |
#      |   1    |