package ecomm.Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelReaderUtility.JsonReader;
import ecomm.BaseActions;
import ecomm.pages.ContactUsPage;

import static extentManager.ExtentTestManager.reporterLog;

public class ContactUsTest extends BaseActions {
	
	private ContactUsPage contactUsPage;
	public Logger logger = LogManager.getLogger(ContactUsTest.class.getName());
	@BeforeTest
	public void BrowserLaunch() throws IOException
	{
		init_Driver();
		logger.info("Initialize and lanuch browser");
		getDriver().get(properties.getProperty("AppUrl"));
		logger.info("Launching the application URL");
	}
	
	@Test(dataProvider="ContactUsData")
	public void verifyContactuspage(String heading,String emailId, String orderReference, String message) throws Exception
	{
		contactUsPage = new ContactUsPage(BaseActions.getDriver());
		contactUsPage.clickContactUs();
		logger.info("Click on the ContactUs Page");
		reporterLog("Click on the ContactUs Page","verifyContactuspage");
		contactUsPage.selectSubjectHeading(heading);
		reporterLog("Click on the SubjectHeading and value as:" +heading, "verifyContactuspage");
		logger.info("Click on the SubjectHeading and value as:" +heading);
		contactUsPage.emailAddress(emailId);
		logger.info("Enter email address as:" +emailId);
		reporterLog("Enter email address as:" +emailId, "verifyContactuspage");
		contactUsPage.orderReference(orderReference);
		logger.info("Enter orderReference as:" +orderReference);
		reporterLog("Enter orderReference as:" +orderReference, "verifyContactuspage");
		contactUsPage.messageText(message);
		logger.info("Enter Meassage:" +message);
		reporterLog("Enter Meassage:" +message, "verifyContactuspage");
		contactUsPage.clickSend();
		logger.info("Click on the Send Button");
		reporterLog("Click on the Send Button", "verifyContactuspage");
		String actualSuccMessg = contactUsPage.getSuccessMessg();
		String expectedSuccessMessage="Your message has been successfully sent to our team.";
		Assert.assertEquals(actualSuccMessg, expectedSuccessMessage);
		reporterLog("Verify the Assert condition", "verifyContactuspage");
	}
	
	@DataProvider(name="ContactUsData")
	public Object[][] passData() throws IOException, ParseException
	{
		return JsonReader.getdata("./src/test/resources/testData/"+"ContactUs.json", "ContactUs",2 , 4);
	}
	
	@AfterTest
	public void quitBrowser()
	{
		getDriver().quit();
	}

}
