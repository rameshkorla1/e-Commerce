package ecomm.Tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelReaderUtility.JsonReader;
import ecomm.BaseActions;
import ecomm.pages.SignUpPage;

public class SignUpJsonTest extends BaseActions{
	
    SignUpPage signupPage;
	
	@BeforeTest
	public void BrowserLaunch() throws IOException
	{
		init_Driver();
		getDriver().get(properties.getProperty("AppUrl"));
	}
	@Test(dataProvider="SignUpData")
	public void userSingup(String customerfirstName,String customerlastName, String password, String firstName,String lastName,
            String company, String address, String city, String state, String postcode, String country, 
            String phone, String alias) throws Exception
	{
		
		signupPage = new SignUpPage(getDriver());
		signupPage.SingUp().click();
		//signupPage.emailAddress("qauser3@aol.com");
		signupPage.CreateEmailAddress();
		signupPage.createaccount().click();
		Thread.sleep(3000);
		signupPage.gender().click();
		Thread.sleep(3000);
		signupPage.firstname().sendKeys(customerfirstName);
		signupPage.lastname().sendKeys(customerlastName);
		signupPage.password().sendKeys(password);
		signupPage.address_firstname().sendKeys(firstName);
		signupPage.address_lastname().sendKeys(lastName);
		signupPage.company().sendKeys(company);
		signupPage.address().sendKeys(address);
		signupPage.city().sendKeys(city);
		signupPage.selectState(state);
		signupPage.postcode().sendKeys(postcode);
		signupPage.country().sendKeys(country);
		signupPage.phone().sendKeys(phone);
		signupPage.alias().sendKeys(alias);
	    signupPage.submit().click();
	    signupPage.logOut();
	}
	
	@AfterTest
	public void quitBrowser()
	{
		//getDriver().quit();
	}

	@DataProvider(name="SignUpData")
	public Object[][] passData() throws IOException, ParseException
	{
		//return JsonReader.getJSONdata(AppConfig.getJsonPath()+"Registration.json", "Registration Data",3);
		return JsonReader.getdata("./src/test/resources/testData/"+"SignUp.json", "UserSignUpData",2 , 13);
	}
}
