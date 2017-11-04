package applib.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import applib.common.ElementLocator;
import corelib.Selenium;

public class InBoxPage implements IInboxPage{
	
	Selenium selenium =null;

	public InBoxPage(Selenium selenium)
	{
		this.selenium = selenium;
	}
	
	/**
	 * Method to logout from gmail 
	 */
	@Override
	public void logOut(String username) {
		
		WebElement element = Selenium.webDriver.findElement(By.xpath("//a[contains(@title,'"+username+"')]"));
		selenium.click(element);
		selenium.click(ElementLocator.GmailInboxPage.btnSignOut_xpath, "xpath");
		
	}


	/**
	 * Method to send email from gmail
	 */
	@Override
	public boolean sendEmail(String toEmail, String subject, String message) {
		boolean isMailSent = false;
		
		selenium.click(ElementLocator.GmailInboxPage.btnComposeEmail_xpath, "xpath");
		selenium.setText(ElementLocator.GmailInboxPage.txtToEmail_Name, "name", toEmail);
		selenium.setText(ElementLocator.GmailInboxPage.txtSubject_Name, "name", subject);
		selenium.setText(ElementLocator.GmailInboxPage.txtMessageBody_xpath, "xpath", message);
		selenium.click(ElementLocator.GmailInboxPage.btnSend_xpath, "xpath");
		
		String successmsg = selenium.getText(ElementLocator.GmailInboxPage.msgSentSuccessfully_xpath, "xpath");
		if(successmsg.equalsIgnoreCase(sendEmailSuccessMsg))
		{
			isMailSent = true;
		}
		
		return isMailSent;
		
	}

}
