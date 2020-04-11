package browser;

import framework.BFrameworkQueryObjects;
import io.appium.java_client.android.AndroidDriver;

public class ChromeBrowser {
	
	public void chromeBrowser(AndroidDriver  driver, BFrameworkQueryObjects queryObjects)	
	{
		driver.get("https://www.google.co.in/");
	}

}
