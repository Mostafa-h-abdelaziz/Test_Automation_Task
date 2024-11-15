package tvTest;

import baseTest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class TvTest  extends BaseTest {

    HomePage homePage;
    WebDriver driver;

    @Test
    public void SearchWithBrandName(){

        homePage= new HomePage(BaseTest.driver);

        homePage.EnterSearchProduct("Smart TV");
        homePage.ClickOnSearchButton();
        String ExpectedResults ="Smart TV";
        String actualResults = homePage.GetActualResults();
        // Validate results
        Assert.assertTrue(actualResults.contains("SmartTV"));
        //Assert.assertEquals(ExpectedResults, actualResults);
    }
}
