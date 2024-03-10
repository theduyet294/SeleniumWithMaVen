package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import page.ElementPage;
import page.HomePage;
import page.TextBoxPage;

//all test case of TexBox Page
public class TextBoxTest extends TestCase {

	@Test
	// TC01
	public void submitSuccessfully() {
		String userNameInput = "Cường";
		String userEmailInput = "theduyet2904@gmail.com";
		String currentAddressInput = "HN";
		String permanentAddressInput = "Saigon";
//		openBrowser();
		// scroll home page to end
		HomePage homePage = new HomePage(testBase.driver);
		homePage.testBase.scrollToEndPage();
		// Từ HomePage click vào Element, điều hướng trang khởi tạo trang Element 
		//mới
		ElementPage elementPage = homePage.clickElement();
		//Từ ElementPage click vào TexBoxPage, điều hướng trang khoiwt tạo trang TextBoxPage mới 
		TextBoxPage textBoxPage = elementPage.clickTextBox();
		// subit ngắn gọn code
		textBoxPage.inputData(userNameInput, userEmailInput, currentAddressInput, permanentAddressInput);
		textBoxPage.clickSubmit();
		assertEquals(textBoxPage.getActualText(textBoxPage.lbName), userNameInput);
		assertEquals(textBoxPage.getActualText(textBoxPage.lbEmail), userEmailInput);
		assertEquals(textBoxPage.getActualText(textBoxPage.lbcrAddress), currentAddressInput);
		assertEquals(textBoxPage.getActualText(textBoxPage.lbperAddress), permanentAddressInput);
	}
	
	@Test
	// TC02
	public void verifyInvaliEmail() {
		String userNameInput = "Cường";
		String userEmailInput = "theduyet2904@gmail.com";
		String currentAddressInput = "HN";
		String permanentAddressInput = "Saigon"; 
		// scroll home page to end
		HomePage homePage = new HomePage(testBase.driver);
		homePage.testBase.scrollToEndPage();

		ElementPage elementPage = homePage.clickElement();
		
		TextBoxPage textBoxPage = elementPage.clickTextBox();
		// subit ngắn gọn code
		textBoxPage.inputData(userNameInput, userEmailInput, currentAddressInput, permanentAddressInput);
		textBoxPage.testBase.scrollToEndPage();
		textBoxPage.clickSubmit();
		assertTrue(textBoxPage.testBase.getValueOfAttribute(textBoxPage.txtEmail,"class").contains("field-error"));
	}
	
	
	
}
