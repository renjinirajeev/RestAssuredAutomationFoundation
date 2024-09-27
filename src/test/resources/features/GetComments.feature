Feature: Get the Comment functionality

  Scenario: verify user get the comment
    Given user wants to call "/comments" end point
    And set header "Content-Type" to "application/json"
    And set request body from the pojo_file "createComments.json"
    When user performs post call
    Then verify status code is 201
    Given user wants to call "/comments/3" end point
    And user perform get call
    Then verify status code is 200


