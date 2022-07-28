Feature:

  Background:
    * call read('AllElements.js')
    * driver 'https://www.youtube.com/c/NaveenAutomationLabs'
    * maximize()

 @case
  Scenario:
    * def channelName = text("//div[@id='inner-header-container']//div[@id='meta']//ytd-channel-name[@id='channel-name']//div[@id='container']//div[@id='text-container']//yt-formatted-string[@id='text']")
    * match channelName == 'Naveen AutomationLabs'
    * close()


