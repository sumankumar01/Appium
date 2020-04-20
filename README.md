# Appium
Appium Framework for Android Device

npm install – g appium –  Latest Stable release version 1.6.9 – Android 7 version

npm uninstall -g appium

//npm install -g appium@beta --no-shrinkwrap

Appium – starts the server



-2.1 – Android 11
appium

C:\Users\kumar>appium

C:\Users\kumar\AppData\Local\Android\Sdk\emulator>emulator -avd suman

C:\Users\kumar\AppData\Local\Android\Sdk\tools\bin\uiautomatorviewer   application to find the xpath

C:\Users\kumar\AppData\Local\Android\Sdk\platform-tools>adb install C:\Users\kumar\Downloads\General-Store.apk  -- install from cmd
Performing Streamed Install
Success


Automatically entering the web view context on session start
asd
----------------------------------------------------------------
driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

Set<String> contextNames = driver.getContextHandles();
for (String contextName : contextNames) {
    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
}
driver.context(contextNames.toArray()[1]); // set context to WEBVIEW_1

//do some web testing
String myText = driver.findElement(By.cssSelector(".green_button")).click();

driver.context("NATIVE_APP");

// do more native testing if we want

driver.quit();

Get Started with Remote Debugging Android Devices
Connect Real android device to automation
--------------------------------------
https://developers.google.com/web/tools/chrome-devtools/remote-debugging
We can't real android device using the teamviewer also using team viewer quick support

C:\WINDOWS\System32>adb devices
List of devices attached
07104e0f0b26    device

Start an Android activity by providing package name and activity name
Apk Info
------------------------------------------------------
http://appium.io/docs/en/commands/device/activity/start-activity/
