function fn() {
  var env = karate.env;
  karate.log('Test environment :', env);


  var config = {
    env: env,
    accessToken : 'e23c998dac52c53e201eb580532f4dc77690afb1a539eb2c068ed79307589c21',
    apiKey : 'e2f4dc48ca5fe1543d15bf268ec6832a',
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
