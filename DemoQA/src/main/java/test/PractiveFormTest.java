package test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import common.Utils;
import page.ElementPage;
import page.FormPage;
import page.HomePage;
import page.PractiveFormPage;

public class PractiveFormTest extends TestCase {
	@Test
	//TC01	
	public void submitDataSuccessfully() {
//		String dataFile = System.getProperty("user.dir")+"testdata\\DemoQA_TestCase_v1.3.xlsx";
//		String dataSheet = "PractiveForm_data";
		
		//String [][] testDataTable = Utils.getTableObject("", null);
		//List<HashMap<String, String>> dataList= Utils.getTestDataFromExcel(dataFile, dataSheet);
		
		String dataFile = System.getProperty("user.dir")+"\\testdata\\PractiveFormData.csv";
		List<Map> listData = Utils.getTestDataFromCSV(dataFile);
		
		HomePage homePage = new HomePage(testBase.driver);
		homePage.testBase.scrollToEndPage();
		// Từ HomePage click vào Form, điều hướng trang khởi tạo trang Form mới
		FormPage formPage = homePage.clickForm(); 
		//Từ Form page click vào practive form 
		PractiveFormPage practiveFormPage = formPage.clickPractiveForm();
		practiveFormPage.inputData(listData.get(0));
		practiveFormPage.clickSubmit();
		
		String actualStudentName = practiveFormPage.getTextResult(practiveFormPage.txtStudentName);
		String expectedStudentName = listData.get(0).get("First name").toString()+ " "+ listData.get(0).get("Last name").toString();
		assertEquals(actualStudentName, expectedStudentName);
		
		String actualStudentEmail = practiveFormPage.getTextResult(practiveFormPage.txtStudentEmail);
		String expectedStudentEmail = listData.get(0).get("Email").toString();
		assertEquals(actualStudentEmail, expectedStudentEmail);
		
		String actualGender = practiveFormPage.getTextResult(practiveFormPage.txtGender);
		String expectedGende = listData.get(0).get("Gender").toString();
		assertEquals(actualGender, expectedGende);
		
		String actualMobile = practiveFormPage.getTextResult(practiveFormPage.txtMobile);
		String expectedMobile = listData.get(0).get("Mobile").toString();
		assertEquals(actualStudentName, expectedStudentName);
		
		String actualDateofBirth = practiveFormPage.getTextResult(practiveFormPage.txtDateofBirth).replace(","," ");
		String expectedDateofBirth = listData.get(0).get("Date of Birth(DD MMM YYYY)").toString();
		assertEquals(actualDateofBirth, expectedDateofBirth);
		 
		
		String actualSubjects = practiveFormPage.getTextResult(practiveFormPage.txtSubjects);
		String expectedSubjects = listData.get(0).get("Subjects").toString();
		assertEquals(actualSubjects, expectedSubjects);
		
		String actualHobbies = practiveFormPage.getTextResult(practiveFormPage.txtHobbies);
		String expectedHobbies = listData.get(0).get("Hobbies").toString();
		assertEquals(actualHobbies, expectedHobbies);
	    
		String actualPicture = practiveFormPage.getTextResult(practiveFormPage.txtPicture);
		String urlPath = listData.get(0).get("Picture").toString();
		
		// Sử dụng lớp File để lấy tên tập tin
        File file = new File(urlPath);
        String fileName = file.getName();
		assertEquals(actualPicture, fileName);
		//chạy đi
		
		String actualAddress = practiveFormPage.getTextResult(practiveFormPage.txtAddress);
		String expectedAddress = listData.get(0).get("Current Address").toString();
		assertEquals(actualAddress, expectedAddress);
		
		String actualStateandCity = practiveFormPage.getTextResult(practiveFormPage.txtStateandCity);
		String expectedStateandCity = listData.get(0).get("State").toString()+ " "+ listData.get(0).get("City").toString();
		assertEquals(actualStateandCity, expectedStateandCity);
	}
	
	
	
}
