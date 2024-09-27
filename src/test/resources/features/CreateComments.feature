Feature: Create Comments functionality

  Scenario: verify user create the comments
    Given user wants to call "/comments" end point
    And set header "Content-Type" to "application/json"
    And set request body from the pojo_file "createComments.json"
    When user performs post call
    Then verify status code is 201







