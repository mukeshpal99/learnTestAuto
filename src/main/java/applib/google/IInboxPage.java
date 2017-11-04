package applib.google;

public interface IInboxPage {
	
	public static String sendEmailSuccessMsg = "Your message has been sent. View message";
	
	public void logOut(String username);
	public boolean sendEmail(String toEmail, String subject, String message);

}
