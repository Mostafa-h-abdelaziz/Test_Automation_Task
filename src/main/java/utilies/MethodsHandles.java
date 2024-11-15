package utilies;

import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodsHandles {

    protected WebDriver driver;
    WebDriverWait wait;

    public MethodsHandles(WebDriver driver) {
        this.driver=driver;
    }


    protected WebElement webElement(By locator){
        return driver.findElement(locator);
    }

    public String getElementText(WebElement element){

        return element.getText();
    }

    //Wait
    protected void explicitWait(By locator, int time){
        wait = new WebDriverWait(driver, Durations.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(webElement(locator)),
                ExpectedConditions.presenceOfElementLocated(locator),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator)
        ));
    }

    // Click Function
    protected void click(By locator,int time){

        explicitWait(locator,time);

        webElement(locator).click();
    }

    // Send Keys Function
    protected void sendKeys(By locator,int time,String text){

        explicitWait(locator,time);
   // scrollIntoView(driver,webElement(locator));
        webElement(locator).sendKeys(text);
    }

    public void EnterTextToElement(WebElement element, String text){

        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text, Keys.ENTER);
    }

}



