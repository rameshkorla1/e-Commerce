package ecomm.pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import ExcelReaderUtility.ExcelReader;
import utilities.excelReader;

public class SignUpPage {
	
	public WebDriver driver;
	Faker data = new Faker();
    excelReader excel;
	
	public SignUpPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By Signup = By.linkText("Sign in");	
	By emailAddress = By.cssSelector("[name='email_create']");
	By createAccount = By.xpath("//button[@name='SubmitCreate']");
	By gender = By.xpath("//input[@id='id_gender1']");
	By firstname = By.name("customer_firstname");
	By lastname = By.name("customer_lastname");
	By password = By.id("passwd");
	By address_firstname = By.id("firstname");
	By address_lastname = By.id("lastname");
	By company = By.id("company");
	By address = By.id("address1");
	By city = By.id("city");
	By state = By.name("id_state");
	By postcode = By.name("postcode");
	By country = By.name("id_country");
	By phone = By.id("phone_mobile");
	By alias = By.xpath("//input[@name='alias']");
	By Submit = By.name("submitAccount");
	
	public WebElement SingUp()
	{
		return driver.findElement(Signup);
	}
	
	public WebElement emailaddress()
	{
		return driver.findElement(emailAddress);
	}
	
	public WebElement createaccount()
	{
		return driver.findElement(createAccount);
	}
	
	public WebElement gender()
	{
		return driver.findElement(gender);
	}
	
	public WebElement firstname()
	{
		return driver.findElement(firstname);
	}
	
	public WebElement lastname()
	{
		return driver.findElement(lastname);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement address_firstname()
	{
		return driver.findElement(address_firstname);
	}
	
	public WebElement address_lastname()
	{
		return driver.findElement(address_lastname);
	}
	
	public WebElement company()
	{
		return driver.findElement(company);
	}
	
	public WebElement address()
	{
		return driver.findElement(address);
	}
	
	public WebElement city()
	{
		return driver.findElement(city);
	}
	
	public WebElement state()
	{
		return driver.findElement(state);
	}
	
	public WebElement postcode()
	{
		return driver.findElement(postcode);
	}
	
	public WebElement country()
	{
		return driver.findElement(country);
	}
	
	public WebElement phone()
	{
		return driver.findElement(phone);
	}
	
	public WebElement alias()
	{
		return driver.findElement(alias);
	}
	
	public WebElement submit()
	{
		return driver.findElement(Submit);
	}
	
	public void emailAddress(String Email)
	{
		emailaddress().sendKeys(Email);
	}
	
	public void logOut()
	{
		driver.findElement(By.xpath("//a[@class='logout']")).click();
	}
	
	public void selectState(String text)
	{
		state().click();
		Select s = new Select(state());
		s.selectByVisibleText(text);  // New York
	}
	
	public void CreateEmailAddress()
	{
		data = new Faker();
		String email = data.internet().emailAddress();
		emailaddress().sendKeys(email);
	}
	
	public void UserSignUp(String CustomerFirstname, String CustomerLastname, String Password,
			String Firstname, String Lastname, String Company, String Address, String City, String State, String Postcode, String Country, String Phone, String Alias)
	{		
		firstname().sendKeys(CustomerFirstname);
		lastname().sendKeys(CustomerLastname);
		password().sendKeys(Password);
		address_firstname().sendKeys(Firstname);
		address_lastname().sendKeys(Lastname);
		company().sendKeys(Company);
		address().sendKeys(Address);
		city().sendKeys(City);
		selectState(State);
		postcode().sendKeys(Postcode);
		country().sendKeys(Country);
		phone().sendKeys(Phone);
		alias().sendKeys(Alias);
	}
	
	public String userDetails(String CustomerFirstname, String CustomerLastname, String Password,
			String Firstname, String Lastname, String Company, String Address, String City, String State, String Postcode, String Country, String Phone, String Alias)
	{		
		firstname().sendKeys(CustomerFirstname);
		lastname().sendKeys(CustomerLastname);
		password().sendKeys(Password);
		address_firstname().sendKeys(Firstname);
		address_lastname().sendKeys(Lastname);
		company().sendKeys(Company);
		address().sendKeys(Address);
		city().sendKeys(City);
		selectState(State);
		postcode().sendKeys(Postcode);
		country().sendKeys(Country);
		phone().sendKeys(Phone);
		alias().sendKeys(Alias);
		return "";
	}
	
	public void signUPwithCellDataFromExcel(String CustomerFirstname, String CustomerLastname, String Password,
			String Firstname, String Lastname, String Company, String Address, String City, String State, String Postcode, String Country, String Phone, String Alias)
{		
		firstname().sendKeys(CustomerFirstname);
		lastname().sendKeys(CustomerLastname);
		password().sendKeys(Password);
		address_firstname().sendKeys(Firstname);
		address_lastname().sendKeys(Lastname);
		company().sendKeys(Company);
		address().sendKeys(Address);
		city().sendKeys(City);
		selectState(State);
		postcode().sendKeys(Postcode);
		country().sendKeys(Country);
		phone().sendKeys(Phone);
		alias().sendKeys(Alias);
			
	}
	
	public void readJsonData() throws IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		String jsonFile = System.getProperty("user.dir")+"/src/test/resources/testData/SignUp.json";
		try  {
		FileReader reader = new FileReader(jsonFile);
		//Read JSON file
		            Object obj = jsonParser.parse(reader);
		            JSONArray usersDetails = (JSONArray) obj;
		            System.out.println(usersDetails); //This prints the entire json file
		            for(int i=0;i<usersDetails.size();i++) {
		            JSONObject users = (JSONObject) usersDetails.get(i);
		            System.out.println(users);//This prints every block - one json object
		            JSONObject user = (JSONObject) users.get("users");
		            System.out.println(user); //This prints each data in the block
		            String customerfirstName = (String) user.get("CustomerfirstName");
		            String customerlastName = (String) user.get("CustomerlastName");
		            String password = (String) user.get("password");
		            String firstName = (String) user.get("firstName");
		            String lastName = (String) user.get("lastName");
		            String company = (String) user.get("company"); 
		            String address = (String) user.get("address");
		            String city = (String) user.get("city");
		            String state = (String) user.get("state");
		            String postcode = (String) user.get("postcode");
		            String country = (String) user.get("country");
		            String phone = (String) user.get("phone");
		            String alias = (String) user.get("alias");
		        
		            String result = userDetails(customerfirstName, customerlastName, password, firstName,
		            		lastName, company, address, city, state, postcode, country, phone, alias);
		            user.put("result", result);

		         } 
		}
		         catch (FileNotFoundException e) {
		e.printStackTrace();
		}
	}

}
