package ecomm.Tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelReaderUtility.ExcelReader;
import ExcelReaderUtility.XLUtility;
import ecomm.BaseActions;
import ecomm.pages.SignUpPage;

public class SignUpXLTest2 extends BaseActions {
	
    SignUpPage signupPage;
    ExcelReader  excelReader;
	@BeforeTest
	public void BrowserLaunch() throws IOException
	{
		init_Driver();
		getDriver().get(properties.getProperty("AppUrl"));
	}
	
	@Test(dataProvider="SignupData")
	public void userSingup(String CustomerFirstname, String CustomerLastname, String Password, String Firstname,
			String Lastname, String Company,String Address, String City, String State, String Postcode, String Country, String Phone, String Alias) throws Exception
	{
		signupPage = new SignUpPage(getDriver());
		signupPage.SingUp().click();
		//signupPage.emailAddress("qauser3@aol.com");
		signupPage.CreateEmailAddress();
		signupPage.createaccount().click();
		Thread.sleep(3000);
		signupPage.gender().click();
			
		signupPage.signUPwithCellDataFromExcel(CustomerFirstname, CustomerLastname, Password, Firstname, Lastname, Company, Address, City, State, Postcode, Country, Phone, Alias);
	
		
	}
	
	@DataProvider(name="SignupData")
	public String [][] getData() throws IOException
	{
		//get the data from excel
		String path = System.getProperty("user.dir") + "/Configurations/SignUpData.xlsx";
		XLUtility xlutil=new XLUtility(path);		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);					
		String loginData[][]=new String[totalrows][totalcols];					
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}				
		}		
		return loginData;
	}

}
