Feature: Create an organization to add board

  Background: Set token
    * call read('faker-helpers.js')


  Scenario: Successful create a new organization
    Given url baseUrl
    * path PostCreateOrganization
    * param key = apiKey
    * param token = accessToken
    * param displayName = getOrganizationName()
    * request ''
    * method post
    * match $.id == "#notnull"
    * def organizationID = $.id
    * print "organizaton id >>>", organizationID
