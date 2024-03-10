package test;

import static org.testng.Assert.assertTrue;

import org.testng.TestNG;
import org.testng.annotations.Test;

import page.CheckBoxPage;
import page.ElementPage;
import page.HomePage;
import page.WebTablePage;

public class WebTableTest extends TestCase{
	
	
	String firstName = "Rô";
	String lastName = "Đen";
	String userEmail = "theduyet2904@gmail.com";
	String age = "24";
	String salary = "323922";
	String department = "Saigon";
	
	
	

	@Test
	//TC01
	public void searchByFirstNameSuccesfully() {
	String textInputSearch = "rr";
	HomePage homePage = new HomePage(testBase.driver);
	homePage.testBase.scrollToEndPage();
	// Từ HomePage click vào Element, điều hướng trang khởi tạo trang Element mới
	ElementPage elementPage = homePage.clickElement();
	elementPage.testBase.scrollToEndPage();
	//Từ ElementPage click vào webTablePage, điều hướng trang khoiwt tạo trang webTablePage mới 
	WebTablePage webTablePage = elementPage.clickWebTable();
	webTablePage.inputSearch(textInputSearch);
	assertTrue(webTablePage.checkSearchResult(webTablePage.firstName, textInputSearch));
	assertTrue(webTablePage.checkSearchResult(webTablePage.lastName, textInputSearch));
	assertTrue(webTablePage.checkSearchResult(webTablePage.age, textInputSearch));
}
	@Test
	//T02
	public void registerNewAccountSuccesfully() {
	
	HomePage homePage = new HomePage(testBase.driver);
	homePage.testBase.scrollToEndPage();
	// Từ HomePage click vào Element, điều hướng trang khởi tạo trang Element mới
	ElementPage elementPage = homePage.clickElement();
	elementPage.testBase.scrollToEndPage();
	//Từ ElementPage click vào webTablePage, điều hướng trang khoiwt tạo trang webTablePage mới 
	WebTablePage webTablePage = elementPage.clickWebTable();
	webTablePage.clickButtonAdd();
	webTablePage.addAccount(firstName, lastName, userEmail, age, salary, department);
	webTablePage.clickSubmit();
	
}
	
	}