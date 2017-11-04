package testlib;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import applib.common.BasePage;
import applib.common.ElementLocator;
import corelib.Config;
import corelib.GlobalSetup;
import corelib.Selenium;

public class AmazonTest {
	
	static BasePage basePage = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		basePage = GlobalSetup.setUp();
		basePage.selenium.loadUrl("http://amazon.in");
		basePage.homePage().login(Config.AmazonUsername, Config.AmazonPassword);
	
	}

	

	@Test
	public void putItemInCart() throws InterruptedException {
		
		basePage.homePage().searchProduct("Hard Disk");
		basePage.homePage().clickOnTheProductInSearchResult("Seagate Backup Plus Slim");
		
		basePage.selenium.selectBrowserTab("2");
		
		basePage.productDetailPage().changeHardDiskCapacicy("2 TB");
		
		basePage.productDetailPage().changehardDiskColor("Silver");
		basePage.productDetailPage().changehardDiskColor("Black");
		basePage.productDetailPage().changehardDiskColor("Blue");
		basePage.productDetailPage().changehardDiskColor("White");
		basePage.productDetailPage().changehardDiskColor("Red");
		basePage.productDetailPage().changehardDiskColor("Rose Gold");
		
		basePage.productDetailPage().changeHardDiskQuantity("2");
		
		basePage.productDetailPage().addProductToCart();
		basePage.productDetailPage().proceedToCheckout();
		
		basePage.selenium.waitForElementToBeClickable(ElementLocator.AmazonProductDetailpage.btnDeliverToThisAddress_xpath, "xpath");
		basePage.selenium.click(ElementLocator.AmazonProductDetailpage.btnDeliverToThisAddress_xpath, "xpath");
		
		basePage.selenium.waitForElementToBeClickable(ElementLocator.AmazonProductDetailpage.btnContinueOnDeliveryOption_xpath, "xpath");
		basePage.selenium.click(ElementLocator.AmazonProductDetailpage.btnContinueOnDeliveryOption_xpath, "xpath");
		
		
		basePage.productDetailPage().selectPaymentMethod("CreditCard");
		basePage.productDetailPage().selectPaymentMethod("DebitCard");
		basePage.productDetailPage().selectPaymentMethod("netBanking");
		basePage.productDetailPage().selectPaymentMethod("cashOnDelivery");
		
		basePage.selenium.click(ElementLocator.AmazonProductDetailpage.lnkHelpPages_xpath, "xpath");
		basePage.selenium.selectBrowserTab("2");
		
		basePage.homePage().logOut();
	}
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		Selenium.closeBrowser();
	}

}
