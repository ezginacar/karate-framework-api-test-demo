
   var Faker = Java.type('com.github.javafaker.Faker');
   var f = new Faker();

   function  getBoardName() { return f.gameOfThrones().character();}
   function getCardName() { return f.color().name(); }
   function getOrganizationName() { return f.company().name(); }
   function getListName() { return f.aviation().airport(); }



