function fn() {
  var env = karate.env;
  karate.log('Test environment :', env);


  var config = {
    env: env,
    baseUrl: 'https://n11.com',
    searchText: 'Singer tradition dikiş makinesi',
    expectedMinPrice: '1.900,00',

  }
  if (!env) {
      env = 'test';
    }

  if (env == 'test') {
    config.baseURL ='https://n11.com'
  } else if(env == 'dev') {
    // config.baseURL ='--------'
  }


   karate.configure('connectTimeout', 10000);
   karate.configure('readTimeout', 5000);

   karate.configure('report',{ showLog: true, showAllSteps: false });

   karate.configure('driver', { type: 'chrome' });

  return config;
 }
