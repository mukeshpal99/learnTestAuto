package applib.common;

public class ElementLocator 
{
	
	public interface GmainLoginPage
	{
		public static final String txtEmail_id = "Email";
		public static final String btnNext_id = "next";
		public static final String txtPassword_id = "Passwd";
		public static final String btnSignIn_id = "signIn";
	}
	
	public interface GmailInboxPage
	{
		public static final String lnkInbox_xpath = "//a[contains(@title,'Inbox')]";
		public static final String lnkFirstEmail_xpath = "//table[@id=':3o']//tbody/tr[1]";
		public static final String btnComposeEmail_xpath = "//div[text()='COMPOSE']";
		public static final String txtToEmail_Name = "to";
		public static final String txtSubject_Name = "subjectbox";
		public static final String txtMessageBody_xpath = "//div[@aria-label='Message Body']";
		public static final String btnSend_xpath = "//div[text()='Send']";
		public static final String msgSentSuccessfully_xpath = "//*[text()[contains(.,'Your message has been sent')]]";
		public static final String btnSignOut_xpath = "//a[text()='Sign out']";
	}
	public interface GmailSettingpage
	{
		public static final String iconSettings_xpath = "//div[@gh='s']/*[@role='button']";
		public static final String lnkSettings_id = "ms";
		public static final String rdbVacationResponderOn_xpath = "//label[text()='Vacation responder on']/../../..//input";
		public static final String txtFirstVacationDate_xpath = "//label[text()='First day:']/../../td[3]//input";
		public static final String txtVacationSubject_xpath = "//input[@aria-label='Subject']";
		public static final String txtVacationMsgBody_xpath = "//div[@aria-label='Vacation responder']";
		public static final String btnSaveChangesSetting_xpath = "//button[text()='Save Changes']";
	}
	
	
	public interface AmazonHomePage
	{
		public static final String lnkSignIn_xpath = "//span[text()='Hello. Sign in']";
		public static final String lnkSignOut_id = "nav-item-signout";
		public static final String txtSearchBox_id = "twotabsearchtextbox";
		public static final String btnSearch_xpath = "//input[@value='Go']";
		public static final String lblLoggedInUser_id= "nav-link-yourAccount";
		
	
	}
	
	
	public interface AmazonSignInPage
	{
		public static final String txtUserName_id = "ap_email";
		public static final String txtPassword_id = "ap_password";
		public static final String btnLogin_id = "signInSubmit";
	}
	
	public interface AmazonProductDetailpage
	{
		public static final String drpQuantity_id = "quantity";
		public static final String btnAddToCard_id = "add-to-cart-button";
		public static final String btnProceedToCheckout_xpath = "(//a[text()[contains(.,'Proceed to checkout')]])[1]";
		public static final String btnDeliverToThisAddress_xpath = "//span/a[contains(@href,'shipaddress_ship_to_this')]";
		public static final String btnContinue_Name = "continue-bottom";
		public static final String btnContinueOnDeliveryOption_xpath= "(//*[@id='shippingOptionFormId']//input[@value='Continue'])[3]/..";
		public static final String lnkHelpPages_xpath = "//a[text()='help pages']";
		
	}

}
