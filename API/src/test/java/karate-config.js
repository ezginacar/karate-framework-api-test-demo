function fn() {
  var env = karate.env;
  karate.log('Test environment :', env);


  var config = {
    env: env,
    accessToken : ${accessToken},
    apiKey : ${apiKey},
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
  if (!env) {
      env = 'test';
    }

  if (env == 'test') {
    config.baseURL ='https://api.trello.com'
  } else if(env == 'dev') {
    // config.baseURL ='--------'
  }

   karate.configure('headers', karate.read('header.js'));

   karate.configure('connectTimeout', 10000);
   karate.configure('readTimeout', 5000);

   karate.configure('report',{ showLog: true, showAllSteps: false })

  return config;
 }
