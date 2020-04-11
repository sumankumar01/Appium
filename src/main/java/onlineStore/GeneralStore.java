package onlineStore;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import framework.BFrameworkQueryObjects;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import static io.appium.java_client.touch.TapOptions.tapOptions;

import io.appium.java_client.android.nativekey.AndroidKey;

import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.offset.ElementOption.element;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import static java.time.Duration.ofSeconds;

public class GeneralStore {
	
	public void login(AndroidDriver  driver, BFrameworkQueryObjects queryObjects) throws InterruptedException
	{
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Suman");
		 driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		driver.findElement(By.id("android:id/text1")).click();

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));");
		driver.findElement(By.xpath("//*[@text='India']")).click();
	     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	     
	     Thread.sleep(2000);
	     
	    List<WebElement> ele= driver.findElements(By.xpath("//*[@text='ADD TO CART']"));
	    ele.get(0).click();
	    //ele.get(1).click();
	   // List<WebElement> ele1= driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

	    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

	    Thread.sleep(4000);
	    
	    WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));

	    TouchAction t=new TouchAction(driver);

	    t.tap(tapOptions().withElement(element(checkbox))).perform();



	    driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	    
	    Set<String> contexts=driver.getContextHandles();

	    for(String contextName :contexts)

	    {

	    System.out.println(contextName);

	    }
	    Thread.sleep(2000);
	    driver.context("WEBVIEW_com.androidsample.generalstore");

	    driver.findElement(By.name("q")).sendKeys("hello");

	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

	    driver.pressKey(new KeyEvent(AndroidKey.BACK));

	    driver.context("NATIVE_APP");


	    
	    
	}

}
