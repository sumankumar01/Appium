package framework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import runner.StartFramework;

public class Roots {
	
	public static String ScanarioBank;
	public static String  ScanarioDescription;
	public  static String  TestData;
	public static String ScanarioBank_Sheet;
	public static String objects;
	public static String ScanarioBank_suite;
	public static String testCaseID;
	public static String exec;
	public static String desc;
	public static HSSFWorkbook wb=null;
	public static HSSFSheet sh=null;
	public static HSSFRow row=null;
	public static HSSFCell testcasecellid=null;
	public static HSSFCell TestDecription=null;
	public static HSSFCell executioncell=null;
	public static HSSFCell browservar=null;
	public static HSSFCell sanityvar=null;
	public static LinkedHashMap<String,String> TCID=new LinkedHashMap<String,String>();
	public static List<String> testcaseidyes =new ArrayList<String>();
	public static List<String> testcaseidyes1 =new ArrayList<String>();
	public static List<String> testdes =new ArrayList<String>();
	public static List<String> ApplicationMode =new ArrayList<String>();
	public static List<String> Sanity =new ArrayList<String>();
	public static Multimap<String, String> map = ArrayListMultimap.create();
	public static AndroidDriver  driver;
	public static String rpt;
	public static String Scanario;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentTest child;
	public static String fileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
	public Date strDate = new Date();
	
	Boolean dir = new File("target/Smart"+fileName).mkdirs();
	Boolean dir2 = new File("target/Smart"+fileName+"/HTML").mkdirs();
	public static Boolean dir1 = new File("target/Smart"+fileName+"/Screenshots").mkdirs();
	public static final String SummaryReportFilePath = "target/Smart"+fileName+"/SummaryTestReport_"+fileName+".html";
	
	File NetorkTraffic = new File("target/Smart"+fileName+"/NetworkTraffic"+fileName+".txt");
	public static final String jenkinsreport = "target/jenkinReport/report.html";
	public String Prop_COPA="src/test/resources/suiteRES.properties";
	public static final String SummaryReportFilePath2 ="target/Smart"+StartFramework.fileName+"/HTML/SummaryTestReport_1"+StartFramework.fileName+".html";
	
	

	
	static File SummaryReportFilePath1=new File(SummaryReportFilePath2);
	
	
	

}
