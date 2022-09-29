package ecomm.Tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import ecomm.BaseActions;
import ecomm.pages.SignUpPage;
import utilities.excelReader;

public class SignUpXLTest extends BaseActions {

SignUpPage signupPage;
	
	@BeforeTest
	public void BrowserLaunch() throws IOException
	{
		init_Driver();
		getDriver().get(properties.getProperty("AppUrl"));
	}
	
	@Test()
	public void userSingup() throws Exception
	{
		signupPage = new SignUpPage(getDriver());
		signupPage.SingUp().click();
		//signupPage.emailAddress("qauser3@aol.com");
		signupPage.CreateEmailAddress();
		signupPage.createaccount().click();
		Thread.sleep(3000);
		signupPage.gender().click();
		excelReader reader = new excelReader();
	

			
		List<Map<String, String>> testData = reader.getData("./Configurations/SignUpData.xlsx", "Sheet1");
		  
//		String custfirstname = testData.get(i).get("CustomerFirstname");
//		String custlastname =  testData.get(i).get("CustomerLastname");
//		String password =  testData.get(i).get("Passowrd");
//		String firstname =  testData.get(i).get("Firstname");
//		String lastname =  testData.get(i).get("Lastname");
//		String company =  testData.get(i).get("Company");
//		String address =  testData.get(i).get("Address");
//		String city =  testData.get(i).get("City");
//		String state =  testData.get(i).get("State");
//		String postcode =  testData.get(i).get("Postcode");
//		String country =  testData.get(i).get("Country");
//		String phone =  testData.get(i).get("Phone");
//		String alias =  testData.get(i).get("Alias");
//		signupPage.UserSignUp(custfirstname, custlastname, password, firstname, lastname, company, address, city, state, postcode, country, phone, alias);
//		
		signupPage.submit().click();
	}
}
