Feature: Create Board for the case study

  Background: Call required fields
    * call read('Organization.feature')
    * call read('faker-helpers.js')
    * url baseUrl

  Scenario: Successful create a new board
    * path PostCreateBoard
    * param key = apiKey
    * param token = accessToken
    * param name = getBoardName()
    * param idOrganization = organizationID
    * request ''
    * method post
    * match $.id == "#notnull"
    * def boardID = $.id
