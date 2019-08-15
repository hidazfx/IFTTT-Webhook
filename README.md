# IFTTT-Webhook
 A basic library that allows easy calls to IFTTT's Maker/Webhook service.
## Tutorial
 The library comes with 2 methods, used for calling to the Webhook and getting output from the Webhook.
 ```java
 //Here's an example of calling to a Webhook using your IFTTT Maker Key.
 IFTTTWebhook.callWebhook(Webhook, Key);
 
 //Here's an example of getting a return string from a Webhook. This will return an empty string if no Webhook has been called before.
 IFTTTWebhook.getWebhookOutput();
 ```
 The .jar file available in this repository also contains a small UI for testing. It's code cam also be viewed and modified through this repository. Combined with the UI, you can also call a Webhook using a command line of your choice. The command would be as follows.
 ```batch
 java -jar IFTTTWebhooks.jar MakerKey Webhook
 ```
