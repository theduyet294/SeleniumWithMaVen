package test;

import org.testng.annotations.BeforeMethod;

import common.TestBase;

public class TestCase {
	public TestBase testBase = new TestBase();
	
	
	@BeforeMethod
	public void openBrowser() {
		testBase.openBrowser("https://demoqa.com/");
		
	}
	
	
}
