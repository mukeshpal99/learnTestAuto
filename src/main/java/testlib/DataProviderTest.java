package testlib;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	
	@DataProvider(name="myTestData")
	public Object[][] bestData()
	{
		return new Object[][] {
			{ "Active Lifestyle", "1700"},
			{ "Balanced Slim Down", "1300"},
			{ "Low-Carb Express", "2400"},
			{ "Power Vegetarian", "2100"},
	};
	}
	
	@Test(dataProvider="myTestData")
	public void testDataProvider(String lifestyle, String expense)
	{
		System.out.println("My Lifestyle: "+lifestyle+"  Expense: "+expense);
	}

}
