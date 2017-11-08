package testlib;

import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGLearningClass {
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		System.out.println("Initlal setup for this test class");
	}


	@Test(groups={"regression", "smoke"})
	public void test1() 
	{
		System.out.println("Running Test 1");
	}

	@Test
	public void test2()
	{
		System.out.println("Running Test 2");
		
	
	}
	
	
	@Test(groups={"regression"})
	public void test3()
	{
		System.out.println("Running Test 3");
		
	
	}
	
	@Test(groups={"regression"})
	public void test4()
	{
		System.out.println("Running Test 4");
		
	
	}
	
	@Test
	public void test5()
	{
		System.out.println("Running Test 5");
		
	
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		System.out.println("Running closing  code");
	} 	

}
