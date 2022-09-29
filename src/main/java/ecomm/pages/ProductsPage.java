package ecomm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
	
	public WebDriver driver;
	
	public ProductsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By womenlink = By.linkText("WOMEN");
	private By moreButton = By.xpath("//*[@id='center_column']/ul/li[2]/div/div[2]/div[2]/a[2]/span");
	private By secondImg = By.xpath("(//div[@class='product-image-container']//a//img)[2]");

	private By quantity = By.id("quantity_wanted");
	private By sizeDrp = By.xpath("//*[@id='group_1']");
	
	private By colour = By.id("color_11");
	private By addToCart = By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']");
	private By proceed = By.xpath("//div[@id='layer_cart']//a[@title='Proceed to checkout']/span");
	private By checkoutProceed = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']");
	private By btnProceed = By.xpath("//button[@class='button btn btn-default button-medium']");
	private By Agree_Terms = By.xpath("//*[@id='cgv']");
	private By processCarrier  =By.xpath("//button[@name='processCarrier']");
	private By cheque = By.xpath("//a[@class='cheque']");
	private By confirm = By.xpath("//*[@id='cart_navigation']/button/span");
	
	private By confirmationText   = By.xpath("//div[@id='center_column']/p[@class='alert alert-success']");
	
	public WebElement womenlink()
	{
		return driver.findElement(womenlink);
	}
	
	public WebElement moreButton()
	{
		return driver.findElement(moreButton);
	}
	
	public WebElement secondImg()
	{
		return driver.findElement(secondImg);
	}
	
	public WebElement quantity()
	{
		return driver.findElement(quantity);
	}
	
	public WebElement sizeDrp()
	{
		return driver.findElement(sizeDrp);
	}
	
	public WebElement colour()
	{
		return driver.findElement(colour);
	}
	
	public WebElement addToCart()
	{
		return driver.findElement(addToCart);
	}
	
	public WebElement proceed()
	{
		return driver.findElement(proceed);
	}
	
	public WebElement checkoutProceed()
	{
		return driver.findElement(checkoutProceed);
	}
	
	public WebElement btnProceed()
	{
		return driver.findElement(btnProceed);
	}
	
	public WebElement agree_Terms()
	{
		return driver.findElement(Agree_Terms);
	}
	
	public WebElement processCarrier()
	{
		return driver.findElement(processCarrier);
	}
	
	public WebElement cheque()
	{
		return driver.findElement(cheque);
	}
	
	public WebElement confirm()
	{
		return driver.findElement(confirm);
	}
	
	public WebElement confirmationText()
	{
		return driver.findElement(confirmationText);
	}
	
	public void secondProductImg_MoreBtn()
	{
		Actions act = new Actions(driver);
		act.moveToElement(secondImg()).moveToElement(moreButton()).click().build().perform();
	}
	
	public void selectSize(String text)
	{
		Select oSelect=new Select(sizeDrp());
		oSelect.selectByVisibleText(text);
	}
}
