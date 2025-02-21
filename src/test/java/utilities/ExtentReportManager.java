package utilities;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	public void onStart(ITestContext testContext) {
		
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName ="Test-Report-" + timeStamp +".html";
		sparkReporter =new ExtentSparkReporter(".\\reports\\" +repName);
		
		sparkReporter.config().setDocumentTitle("opencart Automation Report");
		sparkReporter.config().setDocumentTitle("opencart Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Mudule", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		String os= testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser= testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includeGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		
		if(!includeGroups.isEmpty()) {
		extent.setSystemInfo("Groups", includeGroups.toString());
		}
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+"got successfully executed");
				
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+"got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String impPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(impPath);
		}
		catch(Exception e1) {
			
			e1.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+"got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
	}
	
	
	public void onFinish(ITestContext testContext) {
		
		extent.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir") +"\\reports\\"+repName;
		File extentReport= new File(pathOfExtentReport);	
		
		
		 //This is will automatically open the report in the browser once the test case is completed...
		/*
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(Exception e1) {
			
			e1.printStackTrace();
		}
		
		*/
		 /*
		// Send the email to the orgnaisation
		
		try {
			URL url= new URL("file://"+System.getProperty("user.dir")+"\\reports\\"+repName);
			
			//Create the email message
			ImageHtmlEmail email = new ImageHtmlEmail();
			email.setDataSourceResolver(new DataSourceUrlResolver(url));
			email.setHostName("smtp.googleemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("niranjan.kumar@hotelogix.com", "Niru@12345"));
			email.setSSLOnConnect(true);
			email.setFrom("niranjan.kumar@hotelogix.com"); //sender
			email.setSubject("Test Results");
			email.setMsg("Please find Attached Report ...");
			email.addTo("niranjankumar2252@gmail.com"); // Receiver
			email.attach(url, "extent report", "please check report ....");
			email.send(); //send the email 
			
		}
		catch(Exception e1) {
			
			e1.printStackTrace();
		}		
		
		*/
		
	}
	
}
