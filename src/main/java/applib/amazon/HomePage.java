package applib.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import applib.common.ElementLocator;
import corelib.Selenium;

public class HomePage implements IHomePage
{

	Selenium selenium =null;

	/**
	 * Constructor for class
	 * @param selenium
	 */
	public HomePage(Selenium selenium)
	{
		this.selenium = selenium;
	}
	
	
	/**
	 * Method to login
	 */
	@Override
	public void login(String username, String password) {
		
		selenium.click(ElementLocator.AmazonHomePage.lnkSignIn_xpath, "xpath");
		
		selenium.setText(ElementLocator.AmazonSignInPage.txtUserName_id, "id", username);
		selenium.setText(ElementLocator.AmazonSignInPage.txtPassword_id, "id", password);
		
		selenium.click(ElementLocator.AmazonSignInPage.btnLogin_id, "id");
		selenium.wait(20);
			
	}

	/**
	 * Method to search product on home page
	 */
	@Override
	public void searchProduct(String catogary) {
		
		selenium.setText(ElementLocator.AmazonHomePage.txtSearchBox_id, "id", catogary);
		selenium.click(ElementLocator.AmazonHomePage.btnSearch_xpath, "xpath");
	}


	/**
	 * method to click on product on search result
	 */
	@Override
	public void clickOnTheProductInSearchResult(String product) {
		
		WebElement element = Selenium.webDriver.findElement(By.xpath("//a[contains(@title,'"+product+"')]"));
		selenium.click(element);
		
	}
	
	/** 
	 * Method to logout from application
	 */
	@Override
	public void logOut()
	{
		selenium.mouseHover(ElementLocator.AmazonHomePage.lblLoggedInUser_id, "id");
		selenium.wait(2);
		selenium.click(ElementLocator.AmazonHomePage.lnkSignOut_id, "id");
	}

	
	
}
