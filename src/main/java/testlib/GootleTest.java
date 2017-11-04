package testlib;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.Assert;

import applib.common.BasePage;
import applib.common.ElementLocator;
import corelib.Common;
import corelib.Config;
import corelib.GlobalSetup;
import corelib.Selenium;

public class GootleTest {

	static BasePage basePage = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		basePage = GlobalSetup.setUp();
		basePage.selenium.loadUrl("http://gmail.com");
		basePage.loginPage().login(Config.GoogleUsername, Config.GooglePassword);
	}



	@Test
	public void verifySendEmail() 
	{
		basePage.selenium.click(ElementLocator.GmailInboxPage.lnkInbox_xpath, "xpath");

		boolean isMailSent = basePage.inboxPage().sendEmail(Config.GoogleUsername, "Test Subject", "Test Msg Body");
		Assert.assertTrue(isMailSent, "Error occured while sending email");

	}

	@Test
	public void verifySetVacationResponder()
	{
		int tommrowsDate = Common.getTommorowsDate();
		basePage.settingPage().turnVacationResponderOn(tommrowsDate, "Out Of Office", "Annual Leave");
		
		basePage.settingPage().navigateToSettingPage();
		
		boolean isVacaationRdbSelected = basePage.selenium.isRadioButtonSelected(
				ElementLocator.GmailSettingpage.rdbVacationResponderOn_xpath, "xpath");
	
		Assert.assertTrue(isVacaationRdbSelected, "The vacation radio button is not selected");
		
	
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		basePage.inboxPage().logOut(Config.GoogleUsername);
		Selenium.closeBrowser();
	}

}
