package framework;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import runner.StartFramework;

public class ActivityCapture implements WebDriverEventListener{

	
	/*public void beforeClickOn(WebElement arg0, WebDriver driver) {
		// TODO Auto-generated method stub
		 Date strDate = new Date();
		 Calendar cal = Calendar.getInstance();
		 String sDate = new SimpleDateFormat("MMddyyyy").format(cal.getTime());
		String screenShotName="Copa_"+sDate+RandomStringUtils.random(6, true, false)+".png";
		 String screenShotPath;
		try {
			screenShotPath = CaptureScreenshot.capture(driver,screenShotName,StartFramework.logger);
		   //StartFramework.logger.log(Status.PASS, "Snapshot below: " +StartFramework.logger.addScreenCaptureFromPath(screenShotPath));
		   StartFramework.child.info("Clicking on element->"+arg0, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		 
		   //StartFramework.logger.info("Screenshot").addScreenCaptureFromPath(screenShotPath);
		
		  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartFramework.child.log(Status.PASS, "Getting an Exception"+e);
		}
		
		
	}*/

		public void beforeAlertAccept(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterAlertAccept(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterAlertDismiss(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void beforeAlertDismiss(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void beforeNavigateTo(String url, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterNavigateTo(String url, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void beforeNavigateBack(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterNavigateBack(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void beforeNavigateForward(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterNavigateForward(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void beforeNavigateRefresh(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterNavigateRefresh(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void beforeFindBy(By by, WebElement element, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterFindBy(By by, WebElement element, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterClickOn(WebElement element, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
			// TODO Auto-generated method stub
			
		}

		public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
			// TODO Auto-generated method stub
			
		}

		public void beforeScript(String script, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterScript(String script, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void beforeSwitchToWindow(String windowName, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterSwitchToWindow(String windowName, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void onException(Throwable throwable, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public <X> void beforeGetScreenshotAs(OutputType<X> target) {
			// TODO Auto-generated method stub
			
		}

		public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
			// TODO Auto-generated method stub
			
		}

		public void beforeGetText(WebElement element, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterGetText(WebElement element, WebDriver driver, String text) {
			// TODO Auto-generated method stub
			
		}

		public void beforeClickOn(WebElement arg0, WebDriver driver) {
			
			

			// TODO Auto-generated method stub
			 Date strDate = new Date();
			 Calendar cal = Calendar.getInstance();
			 String sDate = new SimpleDateFormat("MMddyyyy").format(cal.getTime());
			String screenShotName="Copa_"+sDate+RandomStringUtils.random(6, true, false)+".png";
			 String screenShotPath;
			try {
				screenShotPath = CaptureScreenshot.capture(driver,screenShotName,StartFramework.logger);
			   //StartFramework.logger.log(Status.PASS, "Snapshot below: " +StartFramework.logger.addScreenCaptureFromPath(screenShotPath));
			   StartFramework.child.info("Clicking on element->"+arg0, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			 
			   //StartFramework.logger.info("Screenshot").addScreenCaptureFromPath(screenShotPath);
			
			  
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				StartFramework.child.log(Status.PASS, "Getting an Exception"+e);
			}
			
			
		
			
		}


	

	

}
