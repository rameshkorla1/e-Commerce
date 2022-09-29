package productsTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ecomm.BaseActions;
import ecomm.pages.LoginPage;
import ecomm.pages.ProductsPage;
import ecomm.pages.SignUpPage;

public class productTest extends BaseActions {
	
    SignUpPage signupPage;
    LoginPage loginPage;
    ProductsPage productPage;
    
    public Logger logger = LogManager.getLogger(productTest.class.getName());
	
	@BeforeTest
	public void BrowserLaunch() throws IOException
	{
		init_Driver();
		getDriver().get(properties.getProperty("AppUrl"));
		
	}
	
	@Test
	public void addToCartItem() throws Exception
	{
		signupPage = new SignUpPage(getDriver());
		signupPage.SingUp().click();
		logger.info("Click on the SignIn");
		loginPage = new LoginPage(getDriver());
		loginPage.userLogin("test1249@test.com", "PKR@PKR");
		logger.info("Enter the username & password and click on login");
		productPage = new ProductsPage(getDriver());
		productPage.womenlink().click();
		logger.info("Click on the women links");
		productPage.secondProductImg_MoreBtn();
		logger.info("Click on the Second item and more button");
		productPage.quantity().clear();
		productPage.quantity().sendKeys("2");
		logger.info("Enter the quantity of Item");
		productPage.selectSize("M");
		logger.info("Enter the size of Item");
		productPage.colour().click();
		logger.info("Click on the colour of Item");
		productPage.addToCart().click();
		logger.info("Click on the Add To Cart button");
		Thread.sleep(3000);
		productPage.proceed().click();
		logger.info("Click on the Proceed");
		productPage.checkoutProceed().click();
		logger.info("Click on the Checkout Proceed");
		productPage.btnProceed().click();
		logger.info("Click on the Proceed the Item");
		productPage.agree_Terms().click();
		logger.info("Click on the agree and Terms of the Item");
		productPage.processCarrier().click();
		logger.info("Click on the Carrier");
		productPage.cheque().click();
		logger.info("Click on the cheque and proceed");
		productPage.confirm().click();
		logger.info("Click on the Order confirmation");
		//
		String confimrationtext = productPage.confirmationText().getText();
		logger.info("product text:"+confimrationtext);
	}

	@AfterTest
	public void tearDown()
	{
		getDriver().quit();
	}
}
