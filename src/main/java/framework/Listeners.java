package framework;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import runner.StartFramework;

public class Listeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		 Date strDate = new Date();
		 Calendar cal = Calendar.getInstance();
		 String sDate = new SimpleDateFormat("MMddyyyy").format(cal.getTime());
		String screenShotName="Copa_"+sDate+RandomStringUtils.random(6, true, false)+".png";
		 String screenShotPath;
		try {
			screenShotPath = CaptureScreenshot.capture(Roots.driver,screenShotName,StartFramework.logger);
		   //StartFramework.logger.log(Status.PASS, "Snapshot below: " +StartFramework.logger.addScreenCaptureFromPath(screenShotPath));
		   StartFramework.child.info("test case failed at this point", MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/"+screenShotName).build());
		 
		   //StartFramework.logger.info("Screenshot").addScreenCaptureFromPath(screenShotPath);
		
		  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartFramework.child.log(Status.PASS, "Getting an Exception"+e);
		}
		
	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
