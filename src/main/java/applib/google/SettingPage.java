package applib.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import applib.common.ElementLocator;
import corelib.Selenium;

public class SettingPage implements ISettingPage {

	Selenium selenium =null;

	public SettingPage(Selenium selenium)
	{
		this.selenium = selenium;
	}

	/**
	 * method to turn on the vacation reponder in gmail settings
	 */
	@Override
	public void turnVacationResponderOn(int date, String subject, String message) {
		
		navigateToSettingPage();
		selenium.click(ElementLocator.GmailSettingpage.rdbVacationResponderOn_xpath, "xpath");
		
		selenium.click(ElementLocator.GmailSettingpage.txtFirstVacationDate_xpath, "xpath");
		selectDateFromCalenderOnGmailSetting(date);
		
		selenium.setText(ElementLocator.GmailSettingpage.txtVacationSubject_xpath, "xpath", subject);
		selenium.setText(ElementLocator.GmailSettingpage.txtVacationMsgBody_xpath, "xpath", message);
		
		selenium.click(ElementLocator.GmailSettingpage.btnSaveChangesSetting_xpath, "xpath");
	}
	
	/**
	 * method to select date form calender in gmail settings
	 * @param date
	 */
	private void selectDateFromCalenderOnGmailSetting(int date)
	{
		WebElement element = Selenium.webDriver.findElement(By.xpath("(//table/tbody//td[text()='"+date+"'])[1]"));
		selenium.click(element);
	}
	
	/**
	 * Method to navigate to setting page on gmail
	 */
	@Override
	public void navigateToSettingPage()
	{
		selenium.click(ElementLocator.GmailSettingpage.iconSettings_xpath, "xpath");
		selenium.click(ElementLocator.GmailSettingpage.lnkSettings_id, "id");
	}
	
	

}
