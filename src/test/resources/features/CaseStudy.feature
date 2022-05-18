@test
Feature: Case study

  Background: Get required IDs - js libraries
    * call read('Card.feature')
    * call read('faker-helpers.js')
    * url baseUrl


  Scenario: Case Study (update one of card's name than remove cards and boards)
   * def endpoint = PutUpdateCard
   * def endpoint = endpoint.replace('${id}', cardID1)
   * path endpoint
   * header Accept = 'application/json'
   * param token = accessToken
   * param key = apiKey
   * request ''
   * method get
   * status 200
   * def cardNameBefore = $.name
 
 
   * url baseUrl
   * path endpoint
   * header Accept = 'application/json'
   * param token = accessToken
   * param key = apiKey
   * param name = getCardName()
   * request ''
   * method put
   * match response.name != cardNameBefore

    #delete created board, card

    * def endpoint2 = DeleteOrganization
    * def endpoint2 = endpoint.replace('${id}', organizationID)
    * path endpoint2
    * header Accept = 'application/json'
    * param token = accessToken
    * param key = apiKey
    * request ''
    * method delete
    * status 200

   #assertion
    * path endpoint
    * header Accept = 'application/json'
    * param token = accessToken
    * param key = apiKey
    * request ''
    * method get
    * status 404
    
    







