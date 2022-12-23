Feature: Get a specific actor

  Scenario Outline: Getting a specific actor from the DB
    Given an actor exists with id <actorid>
    When I request that actors details
    Then the webpage should show the actors "<firstname>" and "<lastname>"
    Examples:
      | actorid | firstname | lastname      |
      |    1    | PENELOPE  | GUINESS       |
      |    5    | JOHNNY    | LOLLOBRIGIDA  |
      |    3    | ED        | CHASE         |