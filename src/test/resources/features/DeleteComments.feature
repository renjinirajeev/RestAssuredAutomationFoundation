Feature: Delete the Comments functionality

  Scenario: verify user delete comments
    Given user wants to call "/comments" end point
    And set header "Content-Type" to "application/json"
    And set request body from the pojo_file "createComments.json"
    When user performs post call
    Then verify status code is 201
    When  user wants to call "comments/3" end point
    And user perform delete call
    Then verify status code is 204


