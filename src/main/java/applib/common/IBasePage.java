package applib.common;

import applib.amazon.IHomePage;
import applib.amazon.IProductDetailPage;
import applib.google.IInboxPage;
import applib.google.ILoginPage;
import applib.google.ISettingPage;

public interface IBasePage 
{
	//Gmail Pages
	ILoginPage loginPage();
	IInboxPage inboxPage();
	ISettingPage settingPage();
	
	
	//Amazon pages
	IHomePage homePage();
	IProductDetailPage productDetailPage();
}
