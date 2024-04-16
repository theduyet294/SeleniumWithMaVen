package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoSampleWindowAlertPage extends Page {
public By lblMessage = By.xpath("//body");
	public DemoSampleWindowAlertPage(WebDriver dr) {
		super(dr);
		
	}
	
}
