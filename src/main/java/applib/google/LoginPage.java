package applib.google;

import applib.common.ElementLocator;
import corelib.Selenium;

public class LoginPage implements ILoginPage
{
	Selenium selenium =null;

	public LoginPage(Selenium selenium)
	{
		this.selenium = selenium;
	}

	/**
	 * Method to login to gamil account
	 */
	@Override
	public void login(String username, String password) {
		selenium.setText(ElementLocator.GmainLoginPage.txtEmail_id, "id", username);
		selenium.click(ElementLocator.GmainLoginPage.btnNext_id, "id");
		selenium.setText(ElementLocator.GmainLoginPage.txtPassword_id, "id", password);
		selenium.click(ElementLocator.GmainLoginPage.btnSignIn_id, "id");
		
	}

	
}
