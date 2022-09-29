package ecomm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import ExcelReaderUtility.ExcelReader;
import extentManager.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseActions {
	
	private WebDriver driver;
	protected Properties properties;
	ExcelReader excel;
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver init_Driver() throws IOException
	{
		properties = new Properties();
		String filePath = System.getProperty("user.dir")+"/Configurations/config.properties";
		FileInputStream fis = new FileInputStream(filePath);
		properties.load(fis);
		String browser = properties.getProperty("browser");
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		}
		else
		{
			System.out.println("Please pass the correct browset vlaue: "+browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
	}
	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	// Excel Reader Method
	public String[][] getData(String ExcelName, String sheetName) 
	{
		String path = System.getProperty("user.dir") + "/Configurations/" + ExcelName;
		excel = new ExcelReader(path);
		String[][] data = excel.getDataFromSheet(sheetName, ExcelName);
		return data;
	}
	
	//screenshot
	@SuppressWarnings("resource")
	public static synchronized String takeScreenshot(String methodName) {

	    DateFormat dateFormat = new SimpleDateFormat("MMM_dd_yyyy_HH_mm_ss_SSS");
	    Date date = new Date();
	    String dateName = dateFormat.format(date);    
	    String OUTPUT_FOLDER_SCREENSHOTS = "/Screenshots/";
		String filePathExtent = OUTPUT_FOLDER_SCREENSHOTS  + "Web"+ methodName + "_" + dateName + ".png";
	    String filePath = ExtentManager.getReportBaseDirectory() + filePathExtent;
	    String encodedBase64=null;
	    try {
	        File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
	        FileInputStream fileInputStreamReader ;
	        fileInputStreamReader = new FileInputStream(screenshotFile);
	        byte[] bytes = new byte[(int) screenshotFile.length()];
	        fileInputStreamReader.read(bytes);
	        encodedBase64 = Base64.encodeBase64String(bytes);
	        FileUtils.copyFile(screenshotFile, new File(filePath));
	    }catch (IOException e){
	        e.getStackTrace();
	        Reporter.log("Failed To Take screenshot " + e, true);
	    }
	    return encodedBase64;
	}

}
