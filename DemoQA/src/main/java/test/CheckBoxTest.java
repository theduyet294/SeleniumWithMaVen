package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import page.CheckBoxPage;
import page.ElementPage;
import page.HomePage;

public class CheckBoxTest extends TestCase {
	@Test 
	//TC01
	public void  verifyCheckBoxCorrectly() {
		HomePage homePage = new HomePage(testBase.driver);
		homePage.testBase.zoomOut();
		homePage.testBase.scrollToEndPage();

		ElementPage elementPage = homePage.clickElement();
		
		CheckBoxPage checkBoxPage = elementPage.clickCheckBox();
		String actualClass = checkBoxPage.testBase.getValueOfAttribute(checkBoxPage.chkHome, "class");
		//The [Home] checkbox is unchecked.
		assertTrue(actualClass.contains("rct-icon-uncheck"));
		checkBoxPage.clickIconCheckBox();
		//Text is shown: "You have selected : home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile"
		String actualHomeText = checkBoxPage.getactualHomeText();
		String expectedHomeText= "You have selected : home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile";
		assertEquals(actualHomeText, expectedHomeText);
		assertTrue(actualClass.contains("rct-icon-check"));
		
	}
	

}
