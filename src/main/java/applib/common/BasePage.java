package applib.common;

import applib.amazon.HomePage;
import applib.amazon.IHomePage;
import applib.amazon.IProductDetailPage;
import applib.amazon.ProductDetailPage;
import applib.google.IInboxPage;
import applib.google.ILoginPage;
import applib.google.ISettingPage;
import applib.google.InBoxPage;
import applib.google.LoginPage;
import applib.google.SettingPage;
import corelib.Selenium;

public class BasePage implements IBasePage
{
	public Selenium selenium = null;
	
	/**
	 * Constructor for class
	 * @param selenium
	 */
	public BasePage(Selenium selenium)
	{
		this.selenium = selenium;
	}

	@Override
	public ILoginPage loginPage() {
		return new LoginPage(selenium);
	}

	@Override
	public IInboxPage inboxPage() {
		return new InBoxPage(selenium);
	}

	@Override
	public ISettingPage settingPage() {
		return new SettingPage(selenium);
	}

	@Override
	public IHomePage homePage() {
		return new HomePage(selenium);
	}

	@Override
	public IProductDetailPage productDetailPage() {
		return new ProductDetailPage(selenium);
	}
	
	
	
	
}
