Feature:

  Background:
    * call read('AllElements.js')
    * driver baseUrl
    * maximize()
    * eval if(enabled(location_close_info_button)) click(location_close_info_button)
    * def findPrice =
    """
      function(id){
        var locator = "span[data-id='" + id +"'][class^= 'newPrice']";
        return locator;
      }
    """
     * def findLink =
    """
      function(id){
        var locator = "a[data-id='" +id +"']";
        return locator;
      }
    """


 @case
  Scenario:
    * input(searchbox_input, searchText + Key.ENTER)
    * waitFor(search_result_label)
    * def actualURL = driver.url + '&srt=PRICE_LOW'
    * driver actualURL
    * waitFor(search_result_label)
    * def productID = attribute(first_product, 'id').split('-')
    * def productID = productID[1]
    * def a = call findPrice productID
    * def actualPrice = text(a).split(' TL')
    * def actualPrice = actualPrice[0]

    * eval if( actualPrice.valueOf() <= expectedMinPrice.valueOf()) karate.fail("istenen fiyatta ürün bulunamadı...en ucuz ürün fiyatı->{actualPrice}, belirlediğin en düşük fiyat->{expectedMinPrice}")
    * def locator = call findLink productID
    * def productLink = attribute(locator, 'href')
    * print 'LINK>>' + productLink


    #&srt=PRICE_HIGH
