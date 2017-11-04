package applib.amazon;

public interface IProductDetailPage {
	
	public void changeHardDiskCapacicy(String size);
	public void changehardDiskColor(String color);
	public void changeHardDiskQuantity(String quantity);
	public void addProductToCart();
	public void proceedToCheckout();
	public void selectPaymentMethod(String method);

}
