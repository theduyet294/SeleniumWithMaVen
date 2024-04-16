package page;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage extends Page {

	public By chkHome = By.xpath("//label[@for='tree-node-home']/span[1]//*[name()='svg']");

	public CheckBoxPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}

	public void clickIconCheckBox() {
		// click vào check box Home
		driverWeb.findElement(chkHome).click(); 
		// click icon '>'
		driverWeb.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-b tn']")).click();
	}
	
	public String getactualHomeText() {
		String result="";
		for(int i = 1;i<= 17;i++) {
			result =result+"" + driverWeb.findElement(By.xpath("//*[@id='result']/span["+ i +"]")).getText(); 
		}
		
		return result;
	}

}
