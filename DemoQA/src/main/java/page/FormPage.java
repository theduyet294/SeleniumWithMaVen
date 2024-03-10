package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage extends Page{

	public FormPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}

	public PractiveFormPage clickPractiveForm() {
		testBase.driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
		return new PractiveFormPage (testBase.driver);
	} 

}
