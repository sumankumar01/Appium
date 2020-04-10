package apiDemo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.BFrameworkQueryObjects;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Preferences {
	
	
	public void preferences(AndroidDriver  driver, BFrameworkQueryObjects queryObjects) throws IOException
	{
		
		
		String Usernm=queryObjects.getTestData("WiFiName");
		
		
        driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		
		driver.findElement(By.id("android:id/checkbox")).click();
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		driver.findElement(By.className("android.widget.EditText")).sendKeys(Usernm);;
		
		//driver.findElement(By.className("android.widget.EditText")).sendKeys("Hello");
		
		driver.findElement(By.id("android:id/button1")).click();
	}
}
