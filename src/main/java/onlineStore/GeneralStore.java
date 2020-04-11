package onlineStore;

import org.openqa.selenium.By;

import framework.BFrameworkQueryObjects;
import io.appium.java_client.android.AndroidDriver;


public class GeneralStore {
	
	public void login(AndroidDriver  driver, BFrameworkQueryObjects queryObjects)
	{
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Suman");
		 driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		driver.findElement(By.id("android:id/text1")).click();

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));");
		driver.findElement(By.xpath("//*[@text='India']")).click();
	     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}

}
