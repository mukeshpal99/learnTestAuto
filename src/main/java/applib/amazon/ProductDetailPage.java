package applib.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import applib.common.ElementLocator;
import corelib.Selenium;

public class ProductDetailPage implements IProductDetailPage{
	
	public Selenium selenium  = null;
	
	/**
	 * Constructor for class
	 * @param selenium
	 */
	public ProductDetailPage(Selenium selenium)
	{
		this.selenium  = selenium;
	}
	
	/**
	 * Method to change the hard disk capacity
	 */
	@Override
	public void changeHardDiskCapacicy(String size)
	{
		WebElement element = Selenium.webDriver.findElement(By.xpath("//button//span[text()='"+size+"']"));
		selenium.waitForElementToBeClickable(element);
		selenium.click(element);
	}

	/**
	 * Method to change the hard disk color
	 */
	@Override
	public void changehardDiskColor(String color) {
		
		WebElement element = Selenium.webDriver.findElement(By.xpath("//button//img[@alt='"+color+"']"));
		
		selenium.click(element);
		selenium.wait(2);
	}

	/**
	 * method to change the product quantity
	 */
	@Override
	public void changeHardDiskQuantity(String quantity) {
		selenium.selectDropdownByValue(ElementLocator.AmazonProductDetailpage.drpQuantity_id, "id", quantity);
		
	}

	/**
	 * Method to add product to cart
	 */
	@Override
	public void addProductToCart() {
		selenium.waitForElementToBeClickable(ElementLocator.AmazonProductDetailpage.btnAddToCard_id, "id");
		selenium.click(ElementLocator.AmazonProductDetailpage.btnAddToCard_id, "id");
		
	}

	/**
	 * method to proceed to checkout
	 */
	@Override
	public void proceedToCheckout() {
		selenium.waitForElementToBeClickable(ElementLocator.AmazonProductDetailpage.btnProceedToCheckout_xpath, "xpath");
		selenium.click(ElementLocator.AmazonProductDetailpage.btnProceedToCheckout_xpath, "xpath");
		
	}

	/**
	 * method to selecy payment method
	 */
	@Override
	public void selectPaymentMethod(String method) {
		
		WebElement element = Selenium.webDriver.findElement(By.xpath("//input[contains(@value,'"+method+"')]"));
		selenium.waitForElementToBeClickable(element);
		selenium.click(element);
		
	}

}
