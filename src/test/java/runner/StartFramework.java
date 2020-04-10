package runner;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import framework.ActivityCapture;
import framework.Execute;
import framework.Roots;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import io.appium.java_client.android.AndroidDriver;

public class StartFramework extends Roots {

	@BeforeSuite(groups = { "Regression", "Sanity" })
	public void Beforesuit() throws IOException {
		

	}

	@BeforeTest(groups = { "Regression", "Sanity" })
	public void init(ITestContext context) throws IOException {

		htmlReporter = new ExtentHtmlReporter(SummaryReportFilePath);

		htmlReporter.loadXMLConfig("src/test/resources/extent-config.xml");
		extent = new ExtentReports();
		List statusHierarchy = Arrays.asList(Status.FATAL, Status.FAIL, Status.ERROR, Status.WARNING, Status.SKIP,
				Status.PASS, Status.DEBUG, Status.INFO);

		extent.config().statusConfigurator().setStatusHierarchy(statusHierarchy);
		htmlReporter.config().setDocumentTitle("Smart Auto. Report");
		for (String group : context.getIncludedGroups()) {

			System.out.println("group : " + group);

			if (group.equalsIgnoreCase("Regression")) {

				
			}

			else {
				
			}
		}

		extent.attachReporter(htmlReporter);
		
		String hostname = "Unknown";
		InetAddress addr;
		String address = InetAddress.getByName("stackoverflow.com").getHostAddress();
		addr = InetAddress.getLocalHost();
		hostname = addr.getHostName();
		extent.setSystemInfo("IP address of Machine", address);
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", hostname);
		
		extent.attachReporter(htmlReporter);

		
		extent.setAnalysisStrategy(AnalysisStrategy.TEST);
		extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
		extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
	}

	@SuppressWarnings("deprecation")
	@Test(dataProvider = "hybridDataRegression", groups = { "Regression" })
	public void testLogin(String testcaseName, String def, String Mode) throws Exception {
		rpt = testcaseName;
		Scanario = def;
		
		
		System.out.println(testcaseName + "->" + ApplicationMode);
		
		htmlReporter.start();
		logger = extent.createTest(def, testcaseName);
		logger.assignCategory("Execution Report");
		

		ActivityCapture handle = null;
		
		EventFiringWebDriver driver1 = null;
		if (Mode.equalsIgnoreCase("Native")) {
			
			
			

			File fs=new File("src\\test\\resources\\ApiDemos-debug.apk");
			//File appDir = new File("src/test/resource");
			     //File app = new File(appDir, "ApiDemos-debug.apk");
			     DesiredCapabilities cap=new DesiredCapabilities();
					cap.setCapability(MobileCapabilityType.DEVICE_NAME, "suman");
					//cap.setCapability("autoGrantPermissions":True);
					//cap.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.17.0");
					cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
					AndroidDriver<AndroidElement> ad=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			   
			  	

			
		} 	
		else
		{
			
		}
		
		File file = new File(Prop_COPA);
		FileInputStream fs;

		try {
			fs = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fs);
			fs.close();

			ScanarioBank = prop.getProperty("com.scenario.bank");
			ScanarioBank_Sheet = prop.getProperty("com.scenario.bank.sheet");
			ScanarioBank_suite = prop.getProperty("com.scenario.bank.suite");
			ScanarioDescription = prop.getProperty("com.scenario.description");
			TestData = prop.getProperty("com.scenario.TestData");
			objects = prop.getProperty("com.scenario.objects");

			File SDEC = new File(ScanarioDescription);
			try {

				FileInputStream inputStreamScanarioDec = new FileInputStream(SDEC);
				DataFormatter formatter = new DataFormatter();

				
				wb = new HSSFWorkbook(inputStreamScanarioDec);
				sh = wb.getSheet("Scenario");

				
				
				
				String testCaseIDScan = null;
				String next = "";
				int i = 0;
				Boolean flag = true;
				int len = testcaseidyes.size();
				String abc = "";
				int temp = 0;
				String Mod = null;
				String Cla = null;
				String TestDa = null;
				int l = 0;

				abc = testcaseName;

				int Stopwhile = 0;
				int k = 1;
				int u = 0;
				;
				while (Stopwhile < sh.getLastRowNum()) {
					List<String> ls1 = new ArrayList<String>();
					
					String id = null;
					int s = 0;
					row = sh.getRow(k);
					String TID = row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();

					if (abc.equalsIgnoreCase(TID)) { 
						TID = row.getCell(0).toString();
						testCaseIDScan = TID;

						flag = true;
						do {
							row = sh.getRow(k);
							
							HSSFCell Modules = row.getCell(3);
							HSSFCell classToRun = row.getCell(4);
							HSSFCell TestData = row.getCell(5);
							
							
							testCaseIDScan = TID;

							Mod = formatter.formatCellValue(Modules);
							Cla = formatter.formatCellValue(classToRun);
							TestDa = formatter.formatCellValue(TestData);

							k++;

							List<String> ls = new ArrayList<String>();

							map.put(TID, Mod);
							map.put(TID, Cla);
							map.put(TID, TestDa);

							next = formatter.formatCellValue(sh.getRow(k).getCell(0));

						} while (next.equalsIgnoreCase(""));

						Collection<String> values = map.get(TID);

						List<String> ls = new ArrayList<String>();
					
							Execute.run(map, TID, driver1, logger);

						

						break;
					} else {
						flag = false;
						k++;
					}

				}

				wb.close();
				
				

				

			} catch (Exception e) {
				logger.log(Status.FAIL, e);
				logger.log(Status.FAIL, " Getting the exception " + e.getMessage());
				
				
				
				e.printStackTrace();

			}

		} catch (Exception e) {
			logger.log(Status.FAIL, e);
			logger.log(Status.FAIL, "Getting the exception" + e.getMessage());
			
			
			e.printStackTrace();

			

		}

	}
	

	@Test(dataProvider = "hybridDataRegression", groups = { "Sanity" })
	public void testLoginSanity(String testcaseName, String def, String Mode) throws Exception {

		System.out.println(ApplicationMode);
		htmlReporter.start();
		logger = extent.createTest(testcaseName, def);
		

		
		
		
		
		ActivityCapture handle = null;
		EventFiringWebDriver driver1 = null;
		if (Mode.equalsIgnoreCase("Native")) {
		
		} 
		else
		{
			
		}
		
		File file = new File(Prop_COPA);
		FileInputStream fs;

		try {
			fs = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fs);
			fs.close();

			ScanarioBank = prop.getProperty("com.scenario.bank");
			ScanarioBank_Sheet = prop.getProperty("com.scenario.bank.sheet");
			ScanarioBank_suite = prop.getProperty("com.scenario.bank.suite");
			ScanarioDescription = prop.getProperty("com.scenario.description");
			TestData = prop.getProperty("com.scenario.TestData");
			objects = prop.getProperty("com.scenario.objects");

			File SDEC = new File(ScanarioDescription);
			try {

				FileInputStream inputStreamScanarioDec = new FileInputStream(SDEC);
				DataFormatter formatter = new DataFormatter();

				
				wb = new HSSFWorkbook(inputStreamScanarioDec);
				sh = wb.getSheet("Scenario");

				
				
				
				String testCaseIDScan = null;
				String next = "";
				int i = 0;
				Boolean flag = true;
				int len = testcaseidyes.size();
				String abc = "";
				int temp = 0;
				String Mod = null;
				String Cla = null;
				String TestDa = null;
				int l = 0;

				abc = testcaseName;

				int Stopwhile = 0;
				int k = 1;
				int u = 0;
				;
				while (Stopwhile < sh.getLastRowNum()) {
					List<String> ls1 = new ArrayList<String>();
					
					String id = null;
					int s = 0;
					row = sh.getRow(k);
					String TID = row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();

					if (abc.equalsIgnoreCase(TID)) { 
						TID = row.getCell(0).toString();
						testCaseIDScan = TID;

						flag = true;
						do {
							row = sh.getRow(k);
							
							HSSFCell Modules = row.getCell(3);
							HSSFCell classToRun = row.getCell(4);
							HSSFCell TestData = row.getCell(5);
							
							
							testCaseIDScan = TID;

							Mod = formatter.formatCellValue(Modules);
							Cla = formatter.formatCellValue(classToRun);
							TestDa = formatter.formatCellValue(TestData);

							k++;

							List<String> ls = new ArrayList<String>();

							map.put(TID, Mod);
							map.put(TID, Cla);
							map.put(TID, TestDa);

							next = formatter.formatCellValue(sh.getRow(k).getCell(0));

						} while (next.equalsIgnoreCase(""));

						Collection<String> values = map.get(TID);

						List<String> ls = new ArrayList<String>();

						Execute.run(map, TID, driver1, logger);
						

						break;
					} else {
						flag = false;
						k++;
					}

				}

				wb.close();
				logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
				
				extent.config().statusConfigurator();

			} catch (Exception e) {
				logger.log(Status.FAIL, " Getting the exception " + e.getMessage());
				
				extent.config().statusConfigurator();
				e.printStackTrace();

			}

		} catch (Exception e) {
			logger.log(Status.FAIL, " Getting the exception " + e.getMessage());
			
			
			
			e.printStackTrace();
			extent.config().statusConfigurator();

		}

	}

	

	@DataProvider(name = "hybridDataRegression")
	public Object[][] getDataFromDataproviderRegression(ITestContext context) throws IOException {

		Object[][] object = null;
		try {

			File file = new File(Prop_COPA);
			FileInputStream fs;

			fs = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fs);
			fs.close();

			ScanarioBank = prop.getProperty("com.scenario.bank");
			ScanarioBank_Sheet = prop.getProperty("com.scenario.bank.sheet");
			ScanarioBank_suite = prop.getProperty("com.scenario.bank.suite");

			File SBank = new File(ScanarioBank);
			FileInputStream inputStreamScanarioBank = new FileInputStream(SBank);

			
			DataFormatter formatter = new DataFormatter();
			wb = new HSSFWorkbook(inputStreamScanarioBank);
			sh = wb.getSheet(ScanarioBank_Sheet);

			

			for (String group : context.getIncludedGroups()) {

				

				if (group.equalsIgnoreCase("Regression")) {
					

					
					for (int i = 1; i <= sh.getLastRowNum(); i++) {
						row = sh.getRow(i);
						testcasecellid = row.getCell(0);
						TestDecription = row.getCell(1);
						executioncell = row.getCell(4);
						browservar = row.getCell(2);
						;
						sanityvar = row.getCell(2);
						;
						testCaseID = formatter.formatCellValue(testcasecellid);
						exec = formatter.formatCellValue(executioncell);
						desc = formatter.formatCellValue(TestDecription);
						String brw = formatter.formatCellValue(browservar);
						String sanvar = formatter.formatCellValue(sanityvar);
						TCID.put(testCaseID, exec);
						testdes.add(desc);
						ApplicationMode.add(brw);
						Sanity.add(sanvar);
					}
					wb.close();

					Set<String> testcaseid = TCID.keySet();
					List<String> testcaseidyes = new ArrayList<String>();
					List<String> Brovar = new ArrayList<String>();
					List<String> San = new ArrayList<String>();
					Collection<String> Status = TCID.values();

					int i = 0;
					for (String myVal : Status) {
						
						if (myVal.equalsIgnoreCase("n")) {
							i++;

						} else { 
							String asd = testcaseid.toArray()[i].toString();
							testcaseidyes.add(asd);

							i++;
						}
					}
					int p = 0;
					for (String myVal : Status) {
						
						if (myVal.equalsIgnoreCase("n")) {
							p++;

						} else { 
							String asd = testdes.get(p);
							testcaseidyes1.add(asd);
							p++;
						}
					}
					int s = 0;
					for (String myVal : Status) {
						
						if (myVal.equalsIgnoreCase("n")) {
							s++;

						} else { 
							String asd = ApplicationMode.get(s);
							Brovar.add(asd);
							s++;
						}
					}
					

					object = new Object[testcaseidyes.size()][3];
					for (int k = 0; k < testcaseidyes.size(); k++) {
						
						object[k][0] = testcaseidyes.get(k);
						object[k][1] = testcaseidyes1.get(k);
						object[k][2] = Brovar.get(k);
						
						
					}

					break;
				}

				else {
					
					for (int i = 1; i <= sh.getLastRowNum(); i++) {
						row = sh.getRow(i);
						testcasecellid = row.getCell(0);
						TestDecription = row.getCell(1);
						executioncell = row.getCell(3);
						browservar = row.getCell(2);
						;
						sanityvar = row.getCell(2);
						;
						testCaseID = formatter.formatCellValue(testcasecellid);
						exec = formatter.formatCellValue(executioncell);
						desc = formatter.formatCellValue(TestDecription);
						String brw = formatter.formatCellValue(browservar);
						String sanvar = formatter.formatCellValue(sanityvar);
						TCID.put(testCaseID, exec);
						testdes.add(desc);
						ApplicationMode.add(brw);
						Sanity.add(sanvar);
					}
					wb.close();

					Set<String> testcaseid = TCID.keySet();
					List<String> testcaseidyes = new ArrayList<String>();
					List<String> Brovar = new ArrayList<String>();
					List<String> San = new ArrayList<String>();
					Collection<String> Status = TCID.values();

					int i = 0;
					for (String myVal : Status) {
						
						if (myVal.equalsIgnoreCase("n")) {
							i++;

						} else { 
							String asd = testcaseid.toArray()[i].toString();
							testcaseidyes.add(asd);

							i++;
						}
					}
					int p = 0;
					for (String myVal : Status) {
						
						if (myVal.equalsIgnoreCase("n")) {
							p++;

						} else { 
							String asd = testdes.get(p);
							testcaseidyes1.add(asd);
							p++;
						}
					}
					int s = 0;
					for (String myVal : Status) {
						
						if (myVal.equalsIgnoreCase("n")) {
							s++;

						} else { 
							String asd = ApplicationMode.get(s);
							Brovar.add(asd);
							s++;
						}
					}
					

					object = new Object[testcaseidyes.size()][3];
					for (int k = 0; k < testcaseidyes.size(); k++) {
						
						object[k][0] = testcaseidyes.get(k);
						object[k][1] = testcaseidyes1.get(k);
						object[k][2] = Brovar.get(k);
						
						
					}
					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e);
			logger.log(Status.FAIL, "getting exception" + e);

		}
		return object;
	}

	
	@AfterMethod(groups = { "Regression", "Sanity" })
	public void closeBrowser() throws IOException {
		
		try {
			
			
			try {
				driver.close();
				driver.quit();
			} catch (Exception e) {
			}
			extent.flush();
			File htmlFile = new File(SummaryReportFilePath);
			if (!htmlFile.exists())
				htmlFile.createNewFile();
			
		} catch (Exception e) {
		}
	}

	@AfterTest(groups = { "Regression", "Sanity" })
	public void endreport() throws IOException, URISyntaxException {
		extent.config().statusConfigurator();
		extent.flush();
		File htmlFile = new File(SummaryReportFilePath);
		

		
		
		String source = "target/Smart" + fileName + "/Screenshots";
		File srcDir = new File(source);

		
		
		String destination = "src/test/resources/target/jenkinReport/Screenshots";
		
		File f = new File(destination);
		if (f.exists() && f.isDirectory()) {
			String[] entries = f.list();
			for (String s : entries) {
				File currentFile = new File(f.getPath(), s);
				currentFile.delete();
			}
			f.delete();
		}
		if (!f.exists()) {
			Boolean dir1 = new File(destination).mkdirs();
		}
	

		Desktop.getDesktop().browse(htmlFile.toURI());

	}

}
