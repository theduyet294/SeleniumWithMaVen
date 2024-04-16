package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.FramesPage;
import page.HomePage;

public class FramesTest extends TestCase{
    By txtIframe = By.id("sampleHeading");

    @Test
    public void verifyDisplayFrames(){
        HomePage homePage = new HomePage(testBase.driver);
        homePage.testBase.scrollToEndPage();


    }

}
