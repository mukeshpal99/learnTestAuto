package corelib;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.lf5.LogLevel;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium 
{
	public static WebDriver  webDriver = null;
	public static final int timeout = 20;
	
	/**
	 * Method to set the browser before test run
	 * @param browser
	 */
	public static void setBrowser(String browser)
	{
		webDriver = null;
		switch (browser.toLowerCase()) 
		{
			case "chrome":
				System.setProperty("webdriver.chrome.driver", 
						System.getProperty("user.dir")+"\\src\\main\\resources\\"+"chromedriver.exe");
				webDriver = new ChromeDriver();
				break;
				
			case "firefox":
				webDriver = new FirefoxDriver();
				break;
		}
		
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		
	}
	
	/**
	 * Method to close the browser and quit the selenium webdriver 
	 */
	public static void closeBrowser()
	{
		webDriver.close();
		webDriver.quit();
	}
	
	/**
	 * Methos to find elements on web page by differenet means
	 * @param elementIdentifier
	 * @param findBy
	 * @return
	 */
	public WebElement getElement(String elementIdentifier, String findBy) {
		Log.Message("Finding element by identifier " + elementIdentifier
				+ " using " + findBy.toString(), LogLevel.INFO);
		WebElement element = null;
		
		switch (findBy.toLowerCase()) {
		case "name":
			element = webDriver
					.findElement(By.name(elementIdentifier));
			break;
		case "id":
			element = webDriver.findElement(By.id(elementIdentifier));
			break;
		case "xpath":
			try {
				element = webDriver.findElement(By
						.xpath(elementIdentifier));
			} catch (InvalidSelectorException e) {
				webDriver.navigate().refresh();
				wait(10);
				element = webDriver.findElement(By
						.xpath(elementIdentifier));
			}
			break;
		case "linktext":
			element = webDriver.findElement(By
					.linkText(elementIdentifier));
			break;
		case "cssselector":
			element = webDriver.findElement(By
					.cssSelector(elementIdentifier));
			break;
		case "tagname":
			element = webDriver.findElement(By
					.tagName(elementIdentifier));
			break;
		case "classname":
			element = webDriver.findElement(By
					.className(elementIdentifier));
			break;
		}
		return element;
	}
	
	/**
	 * Method to click on a element on web page
	 * @param elementIdentifier
	 * @param findBy
	 */
	public void click(String elementIdentifier, String findBy) {
		WebElement element = getElement(elementIdentifier, findBy);
		click(element);
	}
	
	/**
	 * method to click on element on page
	 * @param element
	 */
	public void click(WebElement element) {
		waitForElementToBeVisible(element);
		Log.Message("Clicking on element: " + element, LogLevel.INFO);
		element.click();
	}
	
	/**
	 * Method to set text to a text box
	 * @param elementIdentifier
	 * @param findBy
	 * @param text
	 */
	public void setText(String elementIdentifier, String findBy, String text) {
		WebElement element = getElement(elementIdentifier, findBy);
		waitForElementToBeVisible(element);
		element.clear();
		Log.Message("Setting the text area with string: " + text, LogLevel.INFO);
		element.sendKeys(text);
	}
	
	/**
	 * Method to wait for element to load on page and become visible
	 * @param elementIdentifier
	 * @param findBy
	 */
	public void waitForElementToBeVisible(String elementIdentifier, String findBy)
	{
		Log.Message("Waiting for element [" + elementIdentifier
				+ "] to appear for " + timeout + " seconds.", LogLevel.INFO);
		WebDriverWait wait = new WebDriverWait(webDriver, timeout);
		wait.until(ExpectedConditions.visibilityOf(getElement(elementIdentifier, findBy)));
	}
	
	/**
	 * Method to wait for element to load on page and become visible
	 * @param elementIdentifier
	 * @param findBy
	 */
	public void waitForElementToBeVisible(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(webDriver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * Method to load url on browser
	 * @param url
	 */
	public void loadUrl(String url)
	{
		webDriver.get(url);
	}
	
	/**
	 * Method to get string message of an element on web page
	 * @param elementIdentifier
	 * @param findBy
	 * @return
	 */
	public String getText(String elementIdentifier, String findBy) {
		String result = "";
		Log.Message("Getting the text value...", LogLevel.INFO);
		WebElement element = getElement(elementIdentifier, findBy);
		waitForElementToBeVisible(element);
		result = element.getText();
		Log.Message("The text value is:" + result.toString(), LogLevel.INFO);
		return result;
	}
	
	/**
	 * Method to check if a radio button is selected
	 * @param elementIdentifier
	 * @param findBy
	 * @return
	 */
	public boolean isRadioButtonSelected(String elementIdentifier, String findBy)
	{
		WebElement element = getElement(elementIdentifier, findBy);
		waitForElementToBeVisible(element);
		boolean isRdbSelected = element.isSelected();
		return isRdbSelected;
	}
	
	
	/**
	 * Method to select item from drop down by value
	 * @param elementIdentifier
	 * @param findBy
	 * @param value
	 * @return
	 */
	public boolean selectDropdownByValue(String elementIdentifier, String findBy,
			String value) {
		boolean result = false;
		try {
			Log.Message("Selecting the dropdown element " + value, LogLevel.INFO);
			Select dropdown = new Select(getElement(elementIdentifier,findBy));
			dropdown.selectByValue(value);
			result = true;
		} catch (Exception exception) {
			Log.Message(
					"Error in selecting dropdown value "
							+ exception.getMessage(), LogLevel.ERROR);
		}
		return result;
	}
	
	
	/**
	 * Method to switch control to other browser tab
	 * @param tabIndex
	 */
	public void selectBrowserTab(String tabIndex) {
		wait(10);
		Set<String> winHandlesList = webDriver.getWindowHandles();
		int i = 1;
		for (String winHandle : winHandlesList) {
			if (i == Integer.parseInt(tabIndex)) {
				webDriver.switchTo().window(winHandle);
				Log.Message("Switched to window index #" + i
						+ ". Window handle :: [" + winHandle + "].",
						LogLevel.INFO);
				Log.Message(
						"Switched window title :: "
								+ webDriver.getTitle(), LogLevel.INFO);
				break;
			}
			i++;
		}
	}
	
	/**
	 * method to wait for specific seconds
	 * @param i
	 */
	public void wait(int i) {
		Log.Message("Waiting for time: " + i + " seconds ", LogLevel.INFO);
		try {
			java.util.concurrent.TimeUnit.SECONDS.sleep(i);
		} catch (InterruptedException e) {
			Log.Message(e.getMessage(), LogLevel.ERROR);
		}
	}
	
	
	/**
	 * Method to mouse hover on an element on page
	 * @param elementIdentifier
	 * @param findBy
	 */
	public void mouseHover(String elementIdentifier, String findBy) {
		Log.Message("Hovering on element: " + elementIdentifier, LogLevel.INFO);
		waitForElementToBeVisible(elementIdentifier, findBy);
		WebElement element = getElement(elementIdentifier, findBy);
		mouseHover(element);
	}
	
	
	/**
	 * Method to mouse hover on an element on page
	 * @param elementIdentifier
	 * @param findBy
	 */
	public void mouseHover(WebElement element)
	{
		Actions actions = new Actions(webDriver);
		actions.moveToElement(element);
		actions.perform();
		Log.Message("Mouse hover on element: " + element, LogLevel.INFO);
	}
	
	
	/**
	 * Method to wait for element to load on page and become clickabe
	 * @param elementIdentifier
	 * @param findBy
	 */
	public void waitForElementToBeClickable(String elementIdentifier, String findBy)
	{
		Log.Message("Waiting for element [" + elementIdentifier
				+ "] to appear for " + timeout + " seconds.", LogLevel.INFO);
		WebDriverWait wait = new WebDriverWait(webDriver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(getElement(elementIdentifier, findBy)));
	}
	
	/**
	 * Method to wait for element to load on page and become clickable
	 * @param elementIdentifier
	 * @param findBy
	 */
	public void waitForElementToBeClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(webDriver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
