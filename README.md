# Karate & Gatling Demo

## UI Module:

![#f03c15](https://via.placeholder.com/15/f03c15/f03c15.png) `Work in progress`

>> Run ui tests with -> mvn clean test -Dtest=UiTestRunner -pl UI



## API Module:

Take api key & access token from-> https://trello.com/app-key than paste then on the related param values on src/test/java/karate-config.js

Case Study:
1- Create a new Board
2- Create 2 cards under the board
3- Update card name of one of the cards than validate 
4- Delete all created cards, boards

>> Run gatling api performance test with -> mvn clean test-compile gatling:test -pl API

>> Run api tests with -> mvn clean test -Dtest=ApiTestRunner -pl API
