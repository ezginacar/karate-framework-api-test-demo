function fn() {
  var env = karate.env;
  karate.log('Test environment :', env);
  if (!env) {
    env = 'test';
  }

  var config = {
    env: env,
    accessToken : ${accessToken},
    apiKey : ${apiKey} ,
    baseUrl: 'https://api.trello.com',

    //endpoints
    PostCreateBoard : '/1/boards/',
    DeleteBoard : '/1/boards/${id}',
    PostCreateCard : '/1/cards',
    PutUpdateCard : '/1/cards/${id}',
    DeleteCard :'/1/cards/${id}',
    PostCreateOrganization : '/1/organizations/',
    DeleteOrganization : '/1/organizations/${id}',
    PostCreateList : '/1/lists'

  }
  if (env == 'test') {
    config.baseURL ='https://trello.com'
  } else  {
    config.baseURL ='--------'
  }

   karate.configure('connectTimeout', 10000);
   karate.configure('readTimeout', 5000);

  return config;
 }