Feature: Update the  functionality

  Scenario: verify user update the comments
    Given user wants to call "/comments" end point
    And set header "Content-Type" to "application/json"
    And set request body from the pojo_file "createComments.json"
    When user performs post call
    Then verify status code is 201
    And  user wants to call "comments/3" end point
    When set header "Content-Type" to "application/json"
    And set request body from the file "updateComments.json"
    And user perform put call
    Then verify status code is 201


