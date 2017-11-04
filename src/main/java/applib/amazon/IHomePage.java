package applib.amazon;

public interface IHomePage {
	
	public void login(String username, String password);
	public void searchProduct(String product);
	public void clickOnTheProductInSearchResult(String product);
	public void logOut();

}
